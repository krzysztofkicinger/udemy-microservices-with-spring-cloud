package com.kicinger.udemy.boot.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class IndexController {

    @RequestMapping("/pages/{name}")
    public String index(Map model, @PathVariable String name) {
        model.put("name", name);
        return "hello";         //name of the page that is in the /templates directory
    }

}
