package com.kicinger.udemy.spring.balancing;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.PingUrl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonSubjectConfiguration {

    @Bean
    public IPing ribbonPing(IClientConfig config) {
        return new PingUrl();
    }

}
