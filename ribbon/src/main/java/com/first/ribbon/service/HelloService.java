package com.first.ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;// RestTemplate+Ribbon去消费服务

    // 当对特定的服务的调用的不可用达到一个阀值（Hystric 是5秒20次） 断路器将会被打开。
    public String hiError(String name) {
        return "hi," + name + ",sorry,error!";
    }
    @HystrixCommand(fallbackMethod = "hiError")//创建了熔断器的功能，并指定了fallbackMethod熔断方法

    public String hiService(String name) {
        // Ribbon提供客户端负载均衡算法(如，连接超时，重试等)(如简单轮询，随机连接等)。
        // 在ribbon中它会根据服务名来选择具体的服务实例，根据服务实例在请求的时候会用具体的url替换掉服务名?

        return restTemplate.getForObject("http://EUREKACLIENT/hi?name=" + name, String.class);
        // return restTemplate.getForObject("http://SERVICE-HI/hi?name="+name,String.class);
    }

}