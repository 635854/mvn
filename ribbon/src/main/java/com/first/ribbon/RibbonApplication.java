package com.first.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient//
@SpringBootApplication
@EnableHystrix//开启hystrix//@EnableCircuitBreaker?
@EnableHystrixDashboard//开启hystrixDashboard
//+ribbon:熔断
//+service+ribbon:Hi
//+ribbon+service:(首次?,启动顺序)延迟HI

//+ribbon{+service-service}:延迟
//{+service}+ribbon{-service}:延迟
public class RibbonApplication {
    // 在微服务架构中，根据业务来拆分成一个个的服务，服务与服务之间可以相互调用（RPC），在Spring Cloud可以用RestTemplate+Ribbon和Feign来调用。

    public static void main(String[] args) {
        SpringApplication.run(RibbonApplication.class, args);
    }

    @Bean//ioc
    @LoadBalanced
    //开启负载均衡//轮流的调用
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // 如果单个服务出现问题，调用这个服务就会出现线程阻塞，此时若有大量的请求涌入，Servlet容器的线程资源会被消耗完毕，导致服务瘫痪。
    // 服务与服务之间的依赖性，故障会传播，会对整个微服务系统造成灾难性的严重后果，这就是服务故障的“雪崩”效应。
    // 执行快速失败，而不是等待响应超时，这很好的控制了容器的线程阻塞。
    // 通过使用Hystrix,我们能方便的防止雪崩效应, 同时使系统具有自动降级和自动恢复服务的效果.
}
