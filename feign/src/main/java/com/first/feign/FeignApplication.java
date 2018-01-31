package com.first.feign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients//Feign
//@EnableHystrixDashboard//开启hystrixDashboard

public class FeignApplication {
    // 1. Feign 采用的是基于接口的注解
    // 1. Feign 整合了ribbon
    // Feign支持可插拔的编码器和解码器
    // Feign:声明式的伪Http客户端

    public static void main(String[] args) {
        SpringApplication.run(FeignApplication.class, args);
    }

    // Feign是自带断路器

}
