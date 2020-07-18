package com.jxkj.managecenter.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

/**
 * @program: blog-dscn
 * @description: Redisson的配置类
 * @author: WuChengXing
 * @create: 2020-07-18 21:43
 **/
@Configuration
public class MyRedissonConfig {

    @Bean(destroyMethod = "shutdown")
    RedissonClient redissonClient() throws IOException {
        Config config = new Config();
        config.useSingleServer()
                .setAddress("redis://192.168.109.135:6379")
                .setPassword("970412@wcx.com");
        return Redisson.create(config);
    }
}
