package com.jxkj.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 认证服务主启动类
 *
 * @author: WuChengXing
 * @create: 2020-07-24 20:00
 **/
@SpringCloudApplication
@RefreshScope
@EnableFeignClients
public class AuthApplication5250 {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication5250.class, args);
    }
}
