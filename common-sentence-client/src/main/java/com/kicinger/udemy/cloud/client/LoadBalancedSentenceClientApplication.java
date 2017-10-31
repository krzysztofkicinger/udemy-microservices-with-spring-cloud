package com.kicinger.udemy.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@EnableDiscoveryClient
@Profile("load-balanced")
public class LoadBalancedSentenceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoadBalancedSentenceClientApplication.class, args);
    }

}
