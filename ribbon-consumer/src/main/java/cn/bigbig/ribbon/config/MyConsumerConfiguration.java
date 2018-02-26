package cn.bigbig.ribbon.config;

import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jiangyi on 2018/2/26.
 */
@Configuration
public class MyConsumerConfiguration {

    @Bean
    public IRule iRule(){
        return new BestAvailableRule();
    }

}
