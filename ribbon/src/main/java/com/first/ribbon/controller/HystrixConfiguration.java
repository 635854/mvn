package com.first.ribbon.controller;// package com.first.ribbon.controller;
//
// import com.netflix.hystrix.contrib.javanica.aop.aspectj.HystrixCommandAspect;
// import org.springframework.boot.web.servlet.ServletRegistrationBean;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// @Configuration
// public class HystrixConfiguration {
// @Bean
// public HystrixCommandAspect hystrixAspect() {
// return new HystrixCommandAspect();
// }
// @Bean
// public ServletRegistrationBean hystrixMetricsStreamServlet() {
// ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
// registration.addUrlMappings(<hystrix.stream>);
// return registration;
// }
// }