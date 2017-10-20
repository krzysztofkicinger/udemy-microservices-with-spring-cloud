package com.kicinger.udemy.spring.balancing;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Configuration;

@Configuration
@RibbonClient(name = "subject", configuration = RibbonSubjectConfiguration.class)
public class RibbonConfiguration {
}
