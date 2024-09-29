package be_project1.lesson_15.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be_project1.lesson_15.constant.URLConstant;
import be_project1.lesson_15.dto.request.CourseRequest;

@RestController
public class CourseController {
    // Create course
    @PostMapping(URLConstant.COURSE_CREATE)
    public Object createCourse(@RequestBody CourseRequest request) {
        return request;
    }

    // Delete course
    @DeleteMapping(URLConstant.COURSE_DELETE)
    public Object deleteCourse(@PathVariable("course_id") String courseID) { 
        return "Course " + courseID + " deleted!";
    }

     // Update course
    @PutMapping(URLConstant.COURSE_UPDATE)
    public Object updateCourse(@PathVariable("course_id") String courseID,  @RequestBody CourseRequest request) { 
        return request;
    }
}
