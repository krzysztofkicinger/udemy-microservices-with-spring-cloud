package com.kicinger.udemy.cloud.clients.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class SentenceController {

    @Autowired
    private DiscoveryClient discoveryClient;
    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/sentence")
    public String getSentence() {
        return getWord("LAB-4-SUBJECT") +
                getWord("LAB-4-VERB") +
                getWord("LAB-4-ARTICLE") +
                getWord("LAB-4-ADJECTIVE") +
                getWord("LAB-4-NOUN");
    }

    private String getWord(String serviceId) {
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances(serviceId);
        return serviceInstances.stream()
                .findFirst()
                .map(instance -> restTemplate.getForObject(instance.getUri(), String.class))
                .orElse(null);
    }

}
