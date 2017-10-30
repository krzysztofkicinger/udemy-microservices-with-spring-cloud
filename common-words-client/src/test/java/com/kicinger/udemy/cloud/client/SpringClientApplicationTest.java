package com.kicinger.udemy.cloud.client;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.AliasFor;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles
public @interface SpringClientApplicationTest {

    @AliasFor(annotation = ActiveProfiles.class, attribute = "profiles")
    String[] value() default {};

}
