package com.jxkj.managecenter.service.impl;

import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.managecenter.entity.BlogInfo;
import com.jxkj.managecenter.form.BlogInfoListForm;
import com.jxkj.managecenter.repository.RedisRepository;
import com.jxkj.managecenter.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        //  = blogInfoListForm.getBlogInfos();
        long countType = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId) && "原创".equals(blogInfo.getBlogType().getType()))
                .count();
        long countLikeNum01 = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                .mapToInt(BlogInfo::getLikeNum)
                .sum();
        long countPageViewNum = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                .mapToInt(BlogInfo::getPageViewNum)
                .sum();
        long countLikeNum = blogInfos.stream()
                .filter(blogInfo -> blogInfo.getTUserId().equals(userId))
                .map(BlogInfo::getBlogLikeUsers).count();

        Map<String, Object> statistics = new ConcurrentHashMap<>(16);
        statistics.put("countType", countType);
        statistics.put("countLikeNum01", countLikeNum01);
        statistics.put("countPageViewNum", countPageViewNum);
        statistics.put("countLikeNum", countLikeNum);
        return ResultBodyUtil.success(statistics);
    }
}
