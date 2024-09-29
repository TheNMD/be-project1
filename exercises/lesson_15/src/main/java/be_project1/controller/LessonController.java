package be_project1.lesson_15.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be_project1.lesson_15.constant.URLConstant;
import be_project1.lesson_15.dto.request.LessonRequest;

@RestController
public class LessonController {
    // Create lesson
    @PostMapping(URLConstant.LESSON_CREATE)
    public Object createLesson(@RequestBody LessonRequest request) {
        return request;
    }

    // Delete lesson
    @DeleteMapping(URLConstant.LESSON_DELETE)
    public Object deleteLesson(@PathVariable("lesson_id") String lessonID) { 
        return "Lesson " + lessonID + " deleted!";
    }

     // Update lesson
    @PutMapping(URLConstant.LESSON_UPDATE)
    public Object updateLesson(@PathVariable("lesson_id") String lessonID,  @RequestBody LessonRequest request) { 
        return request;
    }

    // Begin lesson
    @PostMapping(URLConstant.LESSON_BEGIN)
    public Object beginLesson(@PathVariable("lesson_id") String lessonID) {
        return "Begin lesson " + lessonID + "!";
    }

    // Resume lesson
    @PostMapping(URLConstant.LESSON_RESUME)
    public Object resumeLesson(@PathVariable("lesson_id") String lessonID) {
        return "Resume lesson " + lessonID + "!";
    }

    // Stop lesson
    @PostMapping(URLConstant.LESSON_STOP)
    public Object stopLesson(@PathVariable("lesson_id") String lessonID) {
        return "Stop lesson " + lessonID + "!";
    }
}
