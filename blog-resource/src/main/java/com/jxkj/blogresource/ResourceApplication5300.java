package com.jxkj.blogresource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 功能描述:
 *
 * @Author GuJunBin
 * @Version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransactionManagement
@RefreshScope
@MapperScan(basePackages = "com.jxkj.resource.mapper")
public class ResourceApplication5300 {

    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication5300.class, args);
    }
}
