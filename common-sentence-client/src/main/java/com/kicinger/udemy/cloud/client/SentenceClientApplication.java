package com.kicinger.udemy.cloud.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentenceClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentenceClientApplication.class, args);
    }

}
