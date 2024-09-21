package be_project1.lesson_13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be_project1.lesson_13.dto.request.User;

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
