package com.kicinger.udemy.cloud.servicediscovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.net.URI;
import java.util.List;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClientApplication {

    @Autowired
    private DiscoveryClient discoveryClient;

    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }

    public URI getServiceUri(String serviceName) {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceName);
        if(isSingleServiceExist(serviceInstances)) {
            return serviceInstances.get(0).getUri();
        }
        return null;
    }

    private boolean isSingleServiceExist(List<ServiceInstance> serviceInstances) {
        return serviceInstances != null && serviceInstances.size() > 0;
    }

}
