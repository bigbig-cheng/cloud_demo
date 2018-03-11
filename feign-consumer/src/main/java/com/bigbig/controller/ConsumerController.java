package com.bigbig.controller;

import com.bigbig.core.bean.User;
import com.bigbig.feign.HelloService;
import com.bigbig.feign.RefactorHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by doufu on 2018/3/11.
 */
@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;

    @Autowired
    RefactorHelloService refactorHelloService;

    @RequestMapping(value="/feign-consumer", method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }

    @RequestMapping(value="/feign-consumer2", method = RequestMethod.GET)
    public String helloConsumer2(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\r\n")
                .append(helloService.hello("DIDI")).append("\r\n")
                .append(helloService.hello("DIDI", 30)).append("\r\n")
                .append(helloService.hello(new User("DIDI", 30))).append("\r\n")
                ;
        return sb.toString();
    }

    @RequestMapping(value="/feign-consumer32", method = RequestMethod.GET)
    public String helloConsumer3(){
        StringBuilder sb = new StringBuilder();
        sb.append(helloService.hello()).append("\r\n")
                .append(helloService.hello("MIMI")).append("\r\n")
                .append(helloService.hello("MIMI", 20)).append("\r\n")
                .append(helloService.hello(new User("MIMI", 20))).append("\r\n")
        ;
        return sb.toString();
    }
}
