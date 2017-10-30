package com.kicinger.udemy.cloud.client

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
open class WordsClientApplication {

}

fun main(args: Array<String>) {
    SpringApplication.run(WordsClientApplication::class.java, *args);
}

