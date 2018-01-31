package com.first.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient//
// @EnableDiscoveryClient

// Fetching config from server at: http://localhost:8401/
// Received remote refresh request. Keys refreshed [config.client.version, foo]
@RefreshScope//@Value("${foo}")类

//自定义总线事件
// @RemoteApplicationEventScan(basePackages = "com.example.configclient.event") // tells spring cloud bus to scan for custom events in the current package and subpackages  /**/
public class ConfigclientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigclientApplication.class, args);
	}

	@Value("${foo}")//Could not resolve placeholder 'foo' in value "${foo}"//注释debug
			String foo;

	@RequestMapping(value = "/hi")
	public String hi() {
		return foo;
	}


	// @Bean
	// public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
	// 	PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
	// 	c.setIgnoreUnresolvablePlaceholders(true);
	// 	return c;
	// }
}


