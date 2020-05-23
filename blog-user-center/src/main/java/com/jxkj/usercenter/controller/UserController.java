package com.jxkj.usercenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.usercenter.entity.User;
import com.jxkj.usercenter.service.IUserService;

import io.swagger.annotations.Api;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author GuJunBin
 * @since 2020-05-20
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户表")
public class UserController {


    //@Qualifier("userServiceImpl")
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "注册用户")
    @PostMapping("/register")
    public ResultBody register(@RequestBody User user) {
        return userService.userRegister(user);
    }

    @ApiOperation(value = "用户登录")
    @PostMapping("/login")
    public ResultBody login(String username, String password) {
        return userService.userLogin(username, password);
    }

    @ApiOperation(value = "修改密码")
    @PostMapping("/updatePassword")
    public ResultBody updatePassword(Long userId, String newPassword) {
        return userService.updatePassword(userId, newPassword);
    }

    @ApiOperation(value = "删除用户")
    @PostMapping("/deleteById")
    public ResultBody deleteById(Long userId) {
        return userService.deleteById(userId);
    }
}
