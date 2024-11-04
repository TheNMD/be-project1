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
import org.springframework.validation.annotation.Validated;
import org.springframework.http.ResponseEntity;

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
    public ResponseEntity<?> createLesson(@Validated @RequestBody LessonCreateReq request) {
        Object res = lessonService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @PostMapping(URLConst.READ_LESSON)
    public ResponseEntity<?> readChapter(
        @Validated
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody LessonReadReq request) {
        Object res = lessonService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

     // Update
    @PutMapping(URLConst.UPDATE_LESSON)
    public ResponseEntity<?> updateLesson(
        @Validated
        @PathVariable("id") int id,
        @RequestBody LessonUpdateReq request) {
        Object res = lessonService.update(id, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_LESSON)
    public ResponseEntity<?> deleteLesson(@Validated @PathVariable("id") int id) {
        Object res = lessonService.delete(id);
        return ResponseEntity.ok(res);
    }
}
