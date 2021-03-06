package com.bigbig.feign;

import com.bigbig.core.bean.User;
import com.bigbig.feign.config.HelloServiceConfig;
import com.bigbig.feign.fallback.HelloServiceFallback;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by doufu on 2018/3/11.
 */

@FeignClient(
        value = "hello-service",
        configuration = HelloServiceConfig.class,
        fallback = HelloServiceFallback.class
    )
public interface HelloService {

    @RequestMapping("/hello")
    String hello();

    @RequestMapping(value="/hello1", method = RequestMethod.GET)
    String hello(@RequestParam("name")String name);

    @RequestMapping(value="/hello2", method = RequestMethod.GET)
    User hello(@RequestHeader("name")String name, @RequestHeader("age")Integer age);

    @RequestMapping(value="/hello3", method = RequestMethod.POST)
    String hello(@RequestBody User user);
}
