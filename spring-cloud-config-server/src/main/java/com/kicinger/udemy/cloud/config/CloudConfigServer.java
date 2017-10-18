package com.kicinger.udemy.cloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class CloudConfigServer {

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigServer.class, args);
    }

}
