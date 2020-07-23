package com.jxkj.managecenter;

import com.jxkj.managecenter.sync.BlogCanalClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransactionManagement
@RefreshScope
@EnableCaching
@MapperScan(basePackages = "com.jxkj.managecenter.mapper")
public class ManageCenterApplication5220 implements CommandLineRunner {
    @Resource
    private BlogCanalClient blogCanalClient;

    @Autowired
    private ThreadPoolExecutor executor;

    public static void main(String[] args) {
        SpringApplication.run(ManageCenterApplication5220.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        //项目启动，执行canal客户端监听
        CompletableFuture.runAsync(() -> {
            blogCanalClient.run();
        }, executor);
    }
}
