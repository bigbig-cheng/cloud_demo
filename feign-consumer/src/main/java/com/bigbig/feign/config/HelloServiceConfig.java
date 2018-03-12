package com.bigbig.feign.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jiangyi on 2018/3/12.
 */
@Configuration
public class HelloServiceConfig {

    @Bean
    public Logger.Level loggerLevel(){
        return Logger.Level.FULL;
    }

}
