package com.jxkj.managecenter.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.common.util.DateFormatConvertUtil;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.entity.BlogLikeUser;
import com.jxkj.managecenter.entity.Favorites;
import com.jxkj.managecenter.form.BlogInfoListForm;
import com.jxkj.managecenter.mapper.BlogInfoMapper;
import com.jxkj.managecenter.repository.RedisRepository;
import com.jxkj.managecenter.service.StatisticsService;
import com.jxkj.managecenter.vo.ChartVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
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

    @Autowired
    private BlogInfoMapper blogInfoMapper;

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

    @Override
    public ResultBody countBlogNumber(Long userId) {
        QueryWrapper<BlogInfo> queryWrapper = Wrappers.query();
        queryWrapper.eq("t_user_id", userId);
        List<BlogInfo> blogInfos = blogInfoMapper.selectList(queryWrapper);
        int size = blogInfos.size();
        return ResultBodyUtil.success(size);
    }

    @Override
    public ResultBody countForChart() {
        List<ChartVO> chartVOS = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        Date start = null;
        Date end = null;
        try {
            start = DateFormatConvertUtil.asDate(LocalDate.now().minusDays(7));
            end = DateFormatConvertUtil.asDate(LocalDate.now());
        } catch (Exception e) {
            e.printStackTrace();
        }
        while (!start.equals(end)) {
            calendar.setTime(start);
            String strStartTime = sdf.format(start);
            LocalDateTime startTime = DateFormatConvertUtil.startTime(strStartTime);
            LocalDateTime endTime = DateFormatConvertUtil.endTime(strStartTime);
            QueryWrapper<BlogInfo> queryWrapper = Wrappers.query();
            queryWrapper.between("create_time", startTime, endTime);
            List<BlogInfo> blogInfos = blogInfoMapper.selectList(queryWrapper);
            ChartVO chartVO = new ChartVO();
            chartVO.setDate(strStartTime);
            chartVO.setBlogTodayNum(blogInfos.size());
            chartVOS.add(chartVO);
            calendar.add(Calendar.DATE, 1);
            start = calendar.getTime();
        }
        return ResultBodyUtil.success(chartVOS);
    }

    @Override
    public ResultBody getOneBlogStatistics(Long blogId) {
        BlogInfo blogInfo = blogInfoMapper.findBlogInfoAndTagsByBlogInfoId(blogId);
        Integer pageViewNum = blogInfo.getPageViewNum();
        List<BlogLikeUser> blogLikeUsers = blogInfo.getBlogLikeUsers();
        Integer blogLinkNum = blogLikeUsers.size();
        List<Favorites> favorites = blogInfo.getFavorites();
        Integer favoritesNum = favorites.size();
        Map<String, Object> map = new ConcurrentHashMap<>(16);
        map.put("pageViewNum", pageViewNum);
        map.put("blogLinkNum", blogLinkNum);
        map.put("favoritesNum", favoritesNum);
        return ResultBodyUtil.success(map);
    }
}
