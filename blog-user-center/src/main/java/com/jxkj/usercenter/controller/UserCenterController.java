package com.jxkj.usercenter.controller;

import com.jxkj.common.generator.MybatisPlusGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@RestController
@Slf4j
@RequestMapping("/userCenter")
@Api(tags = "test")
public class UserCenterController {

    /**
     * 功能描述: 测试swagger在微服务中的使用
     *
     * @Author wcx
     * @param name
     * @return java.lang.String
     **/
    @GetMapping("/sayHello")
    @ApiOperation(value = "获取姓名")
    public String sayHello(String name) {
        return "hello: " + name;
    }
}
