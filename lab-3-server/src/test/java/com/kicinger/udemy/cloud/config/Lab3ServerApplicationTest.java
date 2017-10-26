package com.kicinger.udemy.cloud.config;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Lab3ServerApplicationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void whenClientWantsToGetConfigShouldBeSendProperties() {
        ResponseEntity<String> response = restTemplate.getForEntity("/lab-3-client/default", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
//        assertThat()
//        System.out.println(body);
    }

}
