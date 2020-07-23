package com.jxkj.managecenter.config;

import com.jxkj.managecenter.properties.BlogThreadPoolProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 项目: blog-dscn
 * <p>
 * 功能描述: 线程池创建
 *
 * @author: WuChengXing
 * @create: 2020-07-23 14:37
 **/
@Configuration
public class BlogThreadPool {

    @Bean
    public ThreadPoolExecutor threadPoolExecutor(BlogThreadPoolProperties pool) {
        return new ThreadPoolExecutor(pool.getCorePoolSize(),
                pool.getMaximumPoolSize(),
                pool.getKeepAliveTime(),
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(pool.getQueueSize()),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
    }
}
