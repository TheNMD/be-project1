package be_project1.lesson_15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be_project1.lesson_15.constant.URLConstant;
import be_project1.lesson_15.dto.request.UserRequest;
import be_project1.lesson_15.dto.request.CourseRequest;

@RestController
public class UserController {
    // Create user & Login
    @PostMapping(URLConstant.USER_CREATE)
    public Object createUser(@RequestBody UserRequest request) {
        // TODO Hash passwords
        request.setPassword("NotARealPassword"); 
        return request;
    }

    // Delete user
    @DeleteMapping(URLConstant.USER_DELETE)
    public Object deleteUser(@PathVariable("user_id") String userID) { 
        return "User " + userID + " deleted!";
    }

     // Update user
    @PutMapping(URLConstant.USER_UPDATE)
    public Object updateUser(@PathVariable("user_id") String userID,  @RequestBody UserRequest request) { 
        return request;
    }

    // Join a course
    @PostMapping(URLConstant.USER_JOIN_COURSE)
    public Object joinCourse(@PathVariable("course_id") String courseID) {
        return "Joined course " + courseID + "!";
    }

    // Rate a course
    @PostMapping(URLConstant.USER_RATE_COURSE)
    public Object rateCourse(@PathVariable("course_id") String courseID, @RequestBody CourseRequest request) {
        return request;
    }

    // Review a course
    @PostMapping(URLConstant.USER_REVIEW_COURSE)
    public Object reviewCourse(@PathVariable("course_id") String courseID, @RequestBody CourseRequest request) {
        return request;
    }
}
