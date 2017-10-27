package com.kicinger.udemy.cloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Lab4EurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lab4EurekaServerApplication.class, args);
    }

}
