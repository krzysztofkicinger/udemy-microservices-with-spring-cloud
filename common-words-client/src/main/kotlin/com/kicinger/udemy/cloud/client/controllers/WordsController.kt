package com.kicinger.udemy.cloud.client.controllers

import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WordsController {

    @Value("\${words}")
    lateinit var words: String;

    @GetMapping("/")
    fun getWord(): String {
        val possibleWords = words.split(",")
        val position = (Math.random() * (possibleWords.size - 1)).toInt()
        return possibleWords[position];
    }

}