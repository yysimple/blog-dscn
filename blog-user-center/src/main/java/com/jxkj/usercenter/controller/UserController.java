package com.jxkj.usercenter.controller;


import com.jxkj.common.result.ResultBody;
import com.jxkj.common.result.ResultBodyUtil;
import com.jxkj.usercenter.entity.User;
import com.jxkj.usercenter.service.IUserService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.SchemaOutputResolver;

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
@Api(value = "用户表")
public class UserController {


    @Qualifier("userServiceImpl")
    @Autowired
    private IUserService iUserService;

    @ApiImplicitParam(value = "注册用户")
    @PostMapping("/register")
    public ResultBody register(@RequestBody User user){
        System.out.println(user.getUsername());
        ResultBody resultBody = iUserService.userRegister(user);
        return resultBody;
    }

}
