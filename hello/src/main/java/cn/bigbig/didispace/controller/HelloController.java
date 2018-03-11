package cn.bigbig.didispace.controller;

import com.bigbig.core.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jiangyi on 2018/2/24.
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${server.port}")
    private String servicePort;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/helo, host:{},service_id:{}", instance.getHost(), instance.getServiceId());
        return "Hello World:"+servicePort;
    }

    @RequestMapping(value = "/hello1", method = RequestMethod.GET)
    public String hello(@RequestParam String name){
        return "Hello " + name;
    }

    @RequestMapping(value="/hello2", method = RequestMethod.GET)
    public User hello2(@RequestHeader String name, @RequestHeader Integer age){
        return new User(name, age);
    }

    @RequestMapping(value="/hello3", method = RequestMethod.POST)
    public String hello3(@RequestBody User user){
        return "Hello " + user.getName() + ", " + user.getAge();
    }

}
