package com.kicinger.udemy.cloud.bus;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ConfigurationProperties(prefix = "wordConfig")
public class LuckyWordController {

    private String luckyWord;
    private String preamble;

    @RequestMapping("/lucky-word")
    public String showLuckyWord() {
        return preamble + ": " + luckyWord;
    }

    public void setLuckyWord(String luckyWord) {
        this.luckyWord = luckyWord;
    }

    public void setPreamble(String preamble) {
        this.preamble = preamble;
    }
}
