package com.kicinger.udemy.cloud.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

@RestController
public class SentenceController {

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/sentence")
    private String getSentence() {
        return Stream.of(
                getWord("COMMON-SUBJECT"),
                getWord("COMMON-VERB"),
                getWord("COMMON-ARTICLE"),
                getWord("COMMON-ADJECTIVE"),
                getWord("COMMON-NOUN")
        ).collect(joining(" "));
    }

    private String getWord(final String serviceId) {
        return getService(serviceId)
                .map(service -> restTemplate.getForObject(service.getUri(), String.class))
                .orElse(null);
    }

    private Optional<ServiceInstance> getService(final String serviceId) {
        return discoveryClient.getInstances(serviceId).stream().findFirst();
    }

}
