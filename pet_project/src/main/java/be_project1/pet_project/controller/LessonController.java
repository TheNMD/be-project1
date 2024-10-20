package be_project1.pet_project.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.service.LessonService;
import be_project1.pet_project.dto.request.LessonCreateReq;
import be_project1.pet_project.dto.request.LessonReadReq;
import be_project1.pet_project.dto.request.LessonUpdateReq;

@RestController("lessonController")
@RequestMapping("/api/v1")
public class LessonController {
    // Init
    private final LessonService lessonService;

    @Autowired
    public LessonController(@Qualifier("lessonServiceImpl") LessonService lessonService) {
        this.lessonService = lessonService;
    }

    // Create
    @PostMapping(URLConst.CREATE_LESSON)
    public Object createLesson(@RequestBody LessonCreateReq request) {
        return lessonService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_LESSON)
    public Object readChapter(@RequestParam("sort") String sort,
                              @RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestBody LessonReadReq request) {
        return lessonService.read(sort, page, size, request);
    }

     // Update
    @PutMapping(URLConst.UPDATE_LESSON)
    public Object updateLesson(@PathVariable("lesson_id") String lessonID,
                               @RequestBody LessonUpdateReq request) {
        return lessonService.update(lessonID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_LESSON)
    public Object deleteLesson(@PathVariable("lesson_id") String lessonID) {
        return lessonService.delete(lessonID);
    }
}
