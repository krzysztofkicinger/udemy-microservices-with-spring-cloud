package com.kicinger.udemy.cloud.client

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import javax.print.attribute.standard.Media

//@SpringClientApplicationTest(value = "subject")
@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("subject")
class SubjectClientApplicationTest {

    @Value("\${words}")
    lateinit var words: String;

    @Autowired
    lateinit var restTemplate: TestRestTemplate;

    @Test
    fun whenSubjectWordIsRequestedThenOneOfTheSubjectWordsShouldBeReturned() {
        val response = restTemplate.getForEntity("/", String::class.java);
        response.apply {
            assertThat(statusCode).isEqualTo(HttpStatus.OK)
            assertThat(headers.contentType).toString().contains(MediaType.TEXT_PLAIN_VALUE)
            assertThat(body).isNotEmpty().isSubstringOf(words)
        }
    }

}