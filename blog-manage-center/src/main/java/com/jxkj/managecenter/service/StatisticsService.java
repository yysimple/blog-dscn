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

}
