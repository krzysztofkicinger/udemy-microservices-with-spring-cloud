package com.kicinger.udemy.cloud.bus;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class LuckyWordRefreshScopeController {

    @Value("${wordConfig.lucky-word}")
    private String luckyWord;

    @Value("${wordConfig.preamble}")
    private String preamble;

    @RequestMapping("/lucky-word")
    public String showLuckyWord() {
        return preamble + ": " + luckyWord;
    }

}
