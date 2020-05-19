package com.jxkj.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 功能描述：配置路由规则
 *
 * @author wcx
 * @version 1.0
 */
@Configuration
public class RoutesConfig {

/*    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("user-center", r -> r.path("/api/userCenter/**")
                .filters(f -> f.rewritePath("/api/(?<segment>/?.*)", "/$\\{segment}"))
                .uri("lb://user-center")
        ).build();

        return routes.build();
    }*/
}
