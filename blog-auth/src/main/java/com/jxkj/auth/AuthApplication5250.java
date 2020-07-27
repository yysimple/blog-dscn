package com.jxkj.auth;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 认证服务主启动类
 *
 * @author: WuChengXing
 * @create: 2020-07-24 20:00
 **/
@EnableDiscoveryClient
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableSwagger2
@EnableTransactionManagement
@RefreshScope
@EnableFeignClients
public class AuthApplication5250 {
    public static void main(String[] args) {
        SpringApplication.run(AuthApplication5250.class, args);
    }
}
