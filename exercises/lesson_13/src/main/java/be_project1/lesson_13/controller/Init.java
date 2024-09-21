package be_project1.lesson_13.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Init {

    @GetMapping("/welcome")
    public String Welcome() {
        return "Hello course online project";
    }

    @GetMapping("/testing")
    public String Welcome1() {
        return "Testing another API";
    }
}
