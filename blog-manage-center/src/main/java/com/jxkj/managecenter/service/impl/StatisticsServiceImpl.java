package com.jxkj.managecenter.service.impl;

import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.entity.BlogLikeUser;
import com.jxkj.managecenter.entity.Favorites;
import com.jxkj.managecenter.form.BlogInfoListForm;
import com.jxkj.managecenter.repository.RedisRepository;
import com.jxkj.managecenter.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private RedisRepository redisRepository;

    @Override
    public ResultBody allStatistics(Long userId) {
        List<BlogInfo> blogInfos = redisRepository.getObject("blogInfos");
        // 统计原创数
        long countType = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId) && "原创".equals(blogInfo.getBlogType().getType()))
                .count();
        // 待定
        long countLikeNum01 = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                .mapToInt(BlogInfo::getLikeNum)
                .sum();
        // 访问数
        long countPageViewNum = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                .mapToInt(BlogInfo::getPageViewNum)
                .sum();

        // 博客被点赞数
        List<List<BlogLikeUser>> collect = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                .map(BlogInfo::getBlogLikeUsers)
                .collect(Collectors.toList());
        List<BlogLikeUser> likeUsers = new ArrayList<>();
        for (List<BlogLikeUser> blogLikeUsers : collect) {
            likeUsers.addAll(blogLikeUsers);
        }
        long countLikeNum = likeUsers.size();

        // 博客被收藏数
        List<List<Favorites>> collect1 = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                .map(BlogInfo::getFavorites)
                .collect(Collectors.toList());

        List<Favorites> favorites01 = new ArrayList<>();
        for (List<Favorites> favorites : collect1) {
            for (Favorites favorite : favorites) {
                if (favorite.getId() != null) {
                    favorites01.add(favorite);
                }
            }
        }
        long countFavorites = favorites01.size();
        Map<String, Object> statistics = new ConcurrentHashMap<>(16);
        statistics.put("countType", countType);
        // statistics.put("countLikeNum01", countLikeNum01);
        statistics.put("countPageViewNum", countPageViewNum);
        statistics.put("countLikeNum", countLikeNum);
        statistics.put("countFavorites", countFavorites);
        return ResultBodyUtil.success(statistics);
    }
}
