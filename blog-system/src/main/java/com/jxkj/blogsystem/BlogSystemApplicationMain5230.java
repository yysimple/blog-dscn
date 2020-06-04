package com.jxkj.blogsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ysq
 * @description
 * @date 2020/5/30
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransactionManagement
@RefreshScope
@MapperScan(basePackages = "com.jxkj.blogsystem.mapper")
public class BlogSystemApplicationMain5230 {
    public static void main(String[] args) {
        SpringApplication.run(BlogSystemApplicationMain5230.class, args);
    }
}
