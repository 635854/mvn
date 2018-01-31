// package com.first.ribbon.domain;
//
// import com.netflix.hystrix.*;
//
// public class Service1HystrixCommand extends HystrixCommand<Response> {
//   private Service1 service;
//   private Request request;
//
//   public Service1HystrixCommand(Service1 service, Request request){
//     supper(
//       Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ServiceGroup"))
//           .andCommandKey(HystrixCommandKey.Factory.asKey("servcie1query"))
//           .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("service1ThreadPool"))
//           .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
//             .withCoreSize(20))//服务线程池数量
//           .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
//             .withCircuitBreakerErrorThresholdPercentage(60)//熔断器关闭到打开阈值
//             .withCircuitBreakerSleepWindowInMilliseconds(3000)//熔断器打开到关闭的时间窗长度
//       ));
//       // this.service = service;
//       // this.request = request;
//     );
//   }
//
//   @Override
//   protected Response run(){
//     return service1.call(request);
//   }
//
//   @Override
//   protected Response getFallback(){
//     return Response.dummy();
//   }
// }
