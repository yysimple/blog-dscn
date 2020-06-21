package com.jxkj.usercenter.service;

import com.jxkj.common.result.ResultBody;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
public interface UserStatisticsService {

    /**
     * 功能描述: 用户想关统计
     *
     * @Author wcx
     * @param userId
     * @return com.jxkj.common.result.ResultBody
     **/
    ResultBody userAllStatistics(Long userId);
}
