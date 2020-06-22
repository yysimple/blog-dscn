package com.jxkj.managecenter.service;

import com.jxkj.common.result.ResultBody;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public interface StatisticsService {

    /**
     * 功能描述: 统计用户的原创博客、获赞数、访问数
     *
     * @Author wcx
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody allStatistics(Long userId);
    
    /**
     * 功能描述: 统计改用户下的博客总数
     *
     * @Author wcx
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody countBlogNumber(Long userId);

    /**
     * 功能描述: 用于图表统计
     *
     * @Author wcx
     * @param
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody countForChart();

    /**
     * 功能描述: 统计单篇博客
     *
     * @Author wcx
     * @param blogId
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody getOneBlogStatistics(Long blogId);

}
