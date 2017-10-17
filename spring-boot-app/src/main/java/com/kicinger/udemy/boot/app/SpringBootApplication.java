package com.kicinger.udemy.boot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication extends SpringBootServletInitializer {

    /**
     * Startup method when running as a JAR
     *
     * @param args
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

}
