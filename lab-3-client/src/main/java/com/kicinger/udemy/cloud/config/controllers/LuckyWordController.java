package com.kicinger.udemy.cloud.config.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LuckyWordController {

    @Value("${lucky-word}")
    private String luckyWord;

    @GetMapping("/lucky-word")
    public ResponseEntity<String> getLuckyWord() {
        return ResponseEntity.ok(luckyWord);
    }

}
