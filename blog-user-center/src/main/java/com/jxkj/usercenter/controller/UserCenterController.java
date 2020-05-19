package com.jxkj.usercenter.controller;

import lombok.extern.slf4j.Slf4j;
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
public class UserCenterController {

    /**
     * 功能描述: 
     *
     * @Author wcx
     * @param name
     * @return java.lang.String
     **/
    @PostMapping("/sayHello")
    public String sayHello(String name) {
        return "hello: " + name;
    }
}
