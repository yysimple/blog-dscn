package com.jxkj.usercenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.service.IUserFansService;
import com.jxkj.usercenter.service.IUserLevelService;
import com.jxkj.usercenter.service.impl.UserFansServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 用户粉丝表 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-06-21
 */
@RestController
@RequestMapping("/userFans")
@Api(tags = "用户统计接口")
public class UserFansController {

    @Autowired
    private IUserFansService userFansService;

    @GetMapping("/getUserAllFans")
    @ApiOperation(value = "获取所有该用户的所有粉丝数")
    public ResultBody getUserAllFans(Long userId){
        return userFansService.getUserAllFans(userId);
    }
}
