package be_project1.lesson_15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be_project1.lesson_15.dto.request.UserLoginRequest;

@RestController
public class UserController {

    @GetMapping("/welcome")
    public String Welcome() {
        return "Hello course online project";
    }

    @PostMapping("/testing")
    public Object createUser(@RequestBody UserLoginRequest request) {
        // TODO Hash passwords
        request.setPassword("NotARealPassword"); 
        return request;
    }
}
