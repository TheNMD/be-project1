package be_project1.lesson_15.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import be_project1.lesson_15.constant.URLConst;
import be_project1.lesson_15.dto.request.LessonManageReq;
import be_project1.lesson_15.dto.request.LessonSearchReq;
import be_project1.lesson_15.dto.response.LessonSearchRes;

@RestController
public class LessonController {
    // Create lesson
    @PostMapping(URLConst.LESSON_CREATE)
    public Object createLesson(@RequestBody LessonManageReq request) {
        return request;
    }

    // Delete lesson
    @DeleteMapping(URLConst.LESSON_DELETE)
    public Object deleteLesson(@PathVariable("lesson_id") String lessonID) { 
        return "Lesson " + lessonID + " deleted!";
    }

     // Update lesson
    @PutMapping(URLConst.LESSON_UPDATE)
    public Object updateLesson(@PathVariable("lesson_id") String lessonID,  @RequestBody LessonManageReq request) { 
        return request;
    }

    // Search lesson
    @PostMapping(URLConst.LESSON_SEARCH)
    public Object searchChapter(@RequestParam("sort") String sort,
                                @RequestParam("page") int page,
                                @RequestParam("size") int size,
                                @RequestBody LessonSearchReq request) {

        LessonSearchRes response = new LessonSearchRes();
        
        response.setLessonName(request.getLessonName());
        response.setCourseName(request.getCourseName());
        response.setChapterName(request.getChapterName());
        response.setCourseName(request.getCourseName());
        response.setType(request.getType());
        response.setStatus(request.getStatus());
        response.setCreatedDate(request.getCreatedDate());
        response.setSort(sort);
        response.setPage(page);
        response.setSize(size);
            
        return response;
    }

    // Begin lesson
    @PostMapping(URLConst.LESSON_BEGIN)
    public Object beginLesson(@PathVariable("lesson_id") String lessonID) {
        return "Begin lesson " + lessonID + "!";
    }

    // Resume lesson
    @PostMapping(URLConst.LESSON_RESUME)
    public Object resumeLesson(@PathVariable("lesson_id") String lessonID) {
        return "Resume lesson " + lessonID + "!";
    }

    // Stop lesson
    @PostMapping(URLConst.LESSON_STOP)
    public Object stopLesson(@PathVariable("lesson_id") String lessonID) {
        return "Stop lesson " + lessonID + "!";
    }
}
