package com.kicinger.udemy.cloud.config

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CommonConfigServiceTest {

    @Autowired
    lateinit var restTemplate: TestRestTemplate

    @Test
    fun whenDefaultApplicationYamlIsRequestedThenEurekaConfigurationShouldBeProvided() {
        val responseData = restTemplate.getForEntity("/application-default.yml", String::class.java)
        responseData.apply {
            assertThat(statusCode).isEqualTo(HttpStatus.OK)
            assertThat(headers.contentType).isEqualTo(MediaType.TEXT_PLAIN)
            assertThat(body).isNotEmpty().contains("eureka")
        }
    }

}