package com.kicinger.udemy.cloud.clients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Lab4NounClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4NounClientApplication.class, args);
    }

}