package com.kicinger.udemy.cloud.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Lab3ServerApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenClientWantsToGetConfigShouldBeSendProperties() {
        String body = restTemplate.getForEntity("/lab-3-client/default", String.class)
                .getBody();
        System.out.println(body);
    }

}
