package com.jxkj.usercenter.controller;

import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.service.IUserFansService;
import com.jxkj.usercenter.service.UserStatisticsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@RestController
@RequestMapping("/userStatistics")
@Api(tags = "用户相关的统计")
public class UserStatisticsController {

    @Autowired
    private UserStatisticsService userStatisticsService;

    @GetMapping("/userAllStatistics")
    @ApiOperation(value = "获取所有该用户的所有粉丝数")
    public ResultBody userAllStatistics(Long userId){
        return userStatisticsService.userAllStatistics(userId);
    }
}
