package cn.bigbig.didispace.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jiangyi on 2018/2/24.
 */
@RestController
public class HelloController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${service.port}")
    private String servicePort;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/hello")
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/helo, host:{},service_id:{}", instance.getHost(), instance.getServiceId());
        return "Hello World:"+servicePort;
    }

}
