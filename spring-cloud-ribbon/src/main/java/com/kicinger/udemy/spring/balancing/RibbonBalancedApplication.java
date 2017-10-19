package com.kicinger.udemy.spring.balancing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import java.net.URI;

@SpringBootApplication
@RibbonClient
public class RibbonBalancedApplication {

    @Autowired
    private LoadBalancerClient loadBalancer;

    private URI getServiceURI(String serviceName) {
        ServiceInstance instance = loadBalancer.choose(serviceName);
        return URI.create(String.format("http://%s:%s", instance.getHost(), instance.getPort()));
    }

}
