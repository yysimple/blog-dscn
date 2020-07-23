package com.jxkj.usercenter;

import com.jxkj.usercenter.sync.UserCanalClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 功能描述：用户中心模块
 *
 * @author wcx
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransactionManagement
@RefreshScope
@MapperScan(basePackages = "com.jxkj.usercenter.mapper")
public class UserCenterApplication5190 implements CommandLineRunner {

    @Autowired
    private UserCanalClient userCanalClient;

    public static void main(String[] args) {
        SpringApplication.run(UserCenterApplication5190.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        CompletableFuture.runAsync(() -> {
            userCanalClient.run();
        }, new ThreadPoolExecutor(1,
                1,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1),
                new ThreadPoolExecutor.AbortPolicy()));
    }
}
