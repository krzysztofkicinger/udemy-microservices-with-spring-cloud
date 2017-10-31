package com.kicinger.udemy.cloud.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

@RestController
@Profile("load-balanced")
public class LoadBalancedSentenceController {

    @Autowired
    private RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

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

    public String getWord(final String serviceId) {
        return restTemplate.getForObject("http://" + serviceId, String.class);
    }

}
