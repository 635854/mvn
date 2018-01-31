package com.first.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
//+ribbon+zuul{+service延迟}{-service延迟/熔断失效/未到极限?}
public class ZuulApplication {
	//Spring Cloud微服务系统中，一种常见的负载均衡方式是，客户端的请求首先经过负载均衡（zuul、Ngnix），再到达服务网关（zuul集群），然后再到具体的服。

	// Zuul的主要功能是路由转发和过滤器，还可以做一些安全验证
	// zuul默认和Ribbon结合实现了负载均衡的功能


	public static void main(String[] args) {
		SpringApplication.run(ZuulApplication.class, args);
	}
}
