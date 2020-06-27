package com.jxkj.usercenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.usercenter.service.IUserFansService;
import com.jxkj.usercenter.service.IUserLevelService;
import com.jxkj.usercenter.service.impl.UserFansServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@Api(tags = "用户粉丝模块")
public class UserFansController {

    @Autowired
    private IUserFansService userFansService;

    @PostMapping("/attention")
    @ApiOperation(value = "关注用户")
    public ResultBody attention(Long userId, Long fanId){
        return userFansService.attention(userId, fanId);
    }

    @GetMapping("/getAttentionStatus")
    @ApiOperation(value = "获取两个用户之间关注关系")
    public ResultBody getAttentionStatus(Long userId, Long fanId){
        return userFansService.getAttentionStatus(userId, fanId);
    }

    @ApiOperation(value = "获取个人信息模块需要的数据")
    @GetMapping("/forPersonalInfoCount")
    public ResultBody forPersonalInfoCount(Long userId){
        return userFansService.forPersonalInfoCount(userId);
    }

}
