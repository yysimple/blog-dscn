package com.jxkj.fileupload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.filter.CorsFilter;

/**
 * 功能描述：配置跨域放行
 *
 * @author wcx
 * @version 1.0
 */
@Configuration
public class FileUploadCorsConfiguration {

    @Bean
    public CorsFilter corsFilter() {
        //1.添加CORS配置信息
        final CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.setAllowCredentials(true);
        //3) 允许的请求方式
        config.addAllowedMethod("*");
        // 4）允许的头信息
        config.addAllowedHeader("*");
        //5,有效时长
        // com.jxkj.common.config.setMaxAge(3600L);
        //2.添加映射路径，我们拦截一切请求
        final org.springframework.web.cors.UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}
