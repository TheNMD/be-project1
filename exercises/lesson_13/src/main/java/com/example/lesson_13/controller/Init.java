package com.example.lesson_13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Init {

    @GetMapping("/")
    public String Welcome() {
        return "Hello course online project";
    }
}
