package com.jxkj.usercenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.usercenter.form.BlogInfoForm;
import com.jxkj.usercenter.form.UserForm;
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


    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService userService;

    @ApiOperation(value = "注册用户")
    @PostMapping("/register")
    public ResultBody register(@RequestBody UserForm userForm) {
        return userService.userRegister(userForm);
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

    @ApiOperation(value = "根据用户id查询")
    @GetMapping("/selectById")
    public ResultBody selectById(@RequestParam("userId") Long userId) {
        return ResultBodyUtil.success(userService.getById(userId));
    }

    @ApiOperation(value = "分页查询所有用户")
    @GetMapping("/selectAll")
    public ResultBody selectAll(Long current, Long size) {
        return userService.selectAll(current, size);
    }

    @ApiOperation(value = "保存博客并添加分数")
    @PostMapping("/saveBlogInfo")
    public ResultBody saveBlogInfo(BlogInfoForm blogInfoForm, Long[] tagIds, Long typeId, Long userId){
        return userService.saveBlogInfo(blogInfoForm, tagIds, typeId, userId);
    }

    @ApiOperation(value = "删除博客并减分数")
    @GetMapping("/deleteBlogInfoById")
    public ResultBody deleteBlogInfoById(Long userId, Long blogId){
        return userService.deleteBlogInfoById(userId, blogId);
    }

    @ApiOperation(value = "根据用户id查询详细信息")
    @GetMapping("/selectUserInfoById")
    public  ResultBody selectUserInfoById(Long userId){
        return userService.selectUserInfoById(userId);
    }
}
