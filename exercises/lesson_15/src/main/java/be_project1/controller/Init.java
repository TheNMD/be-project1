package be_project1.lesson_15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be_project1.lesson_15.dto.User;

@RestController
public class Init {

    @GetMapping("/welcome")
    public String Welcome() {
        return "Hello course online project";
    }

    @PostMapping("/testing")
    public User createUser(@RequestBody User user) {
        // TODO Hash passwords
        user.setPassword("NotARealPassword"); 
        return user;
    }
}