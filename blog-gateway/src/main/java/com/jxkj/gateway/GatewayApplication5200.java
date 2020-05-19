package com.jxkj.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 功能描述：
 *
 * @author wcx
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication5200 {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication5200.class, args);
    }
}
