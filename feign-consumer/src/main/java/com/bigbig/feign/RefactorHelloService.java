package com.bigbig.feign;

import org.springframework.cloud.netflix.feign.FeignClient;

/**
 * Created by doufu on 2018/3/11.
 */
@FeignClient("HELLO-SERVICE")
public interface RefactorHelloService extends com.bigbig.service.HelloService {

}
