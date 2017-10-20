package com.kicinger.udemy.spring.feign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SpringRestTemplateExample {

    private RestTemplate restTemplate = new RestTemplate();

    private String getName() {
        String url = "http://localhost:8080/{0}";
        return restTemplate.getForObject(url, String.class, 123);
    }

}
