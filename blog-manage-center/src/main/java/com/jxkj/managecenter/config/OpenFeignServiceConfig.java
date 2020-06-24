package com.jxkj.managecenter.config;

import feign.Request;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述：设置openfeign的连接超时时间
 *
 * @author wcx
 * @version 1.0
 */
@Configuration
public class OpenFeignServiceConfig {

    @Value("${service.feign.connectTimeout:60000}")
    private int connectTimeout;

    @Value("${service.feign.readTimeOut:60000}")
    private int readTimeout;

    @Bean
    public Request.Options options() {
        return new Request.Options(connectTimeout, readTimeout);
    }
}
