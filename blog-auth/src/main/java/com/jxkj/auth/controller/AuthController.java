package com.jxkj.auth.controller;

import com.jxkj.auth.service.AuthService;
import com.jxkj.common.result.ResultBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 认证的controller
 *
 * @author: WuChengXing
 * @create: 2020-07-27 09:23
 **/
@RestController
@RequestMapping("/auth")
@Api(tags = "认证中心")
public class AuthController {

    @Autowired
    private AuthService authService;

    @ApiOperation(value = "微博登录")
    @PostMapping("/weiboLogin")
    public ResultBody weiboLogin(String code) {
        return authService.weiboLogin(code);
    }
}
