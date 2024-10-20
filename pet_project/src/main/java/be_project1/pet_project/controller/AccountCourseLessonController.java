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
import be_project1.pet_project.service.AccountCourseLessonService;
import be_project1.pet_project.dto.request.AccountCourseLessonCreateReq;
import be_project1.pet_project.dto.request.AccountCourseLessonReadReq;
import be_project1.pet_project.dto.request.AccountCourseLessonUpdateReq;

@RestController("accountCourseLessonController")
@RequestMapping("/api/v1")
public class AccountCourseLessonController {
    // Init
    private final AccountCourseLessonService accountCourseLessonService;

    @Autowired
    public AccountCourseLessonController(@Qualifier("accountCourseLessonServiceImpl") AccountCourseLessonService accountCourseLessonService) {
        this.accountCourseLessonService = accountCourseLessonService;
    }

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT_COURSE_LESSON)
    public ResponseEntity<?> createAccountCourseLesson(@Validated @RequestBody AccountCourseLessonCreateReq request) {
        Object res = accountCourseLessonService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT_COURSE_LESSON)
    public ResponseEntity<?> readAccountCourseLesson(
        @Validated
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody AccountCourseLessonReadReq request) {
        Object res = accountCourseLessonService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

     // Update
    @PutMapping(URLConst.UPDATE_ACCOUNT_COURSE_LESSON)
    public ResponseEntity<?> updateAccountCourseLesson(
        @Validated
        @PathVariable("lesson_id") String courseID,
        @RequestBody AccountCourseLessonUpdateReq request) {
        Object res = accountCourseLessonService.update(courseID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT_COURSE_LESSON)
    public ResponseEntity<?> deleteAccountCourseLesson(@Validated @PathVariable("lesson_id") String courseID) {
        Object res = accountCourseLessonService.delete(courseID);
        return ResponseEntity.ok(res);
    }

    // Start
    @PostMapping(URLConst.START_LESSON)
    public ResponseEntity<?> startLesson(@Validated @PathVariable("lesson_id") String lessonID) {
        Object res = accountCourseLessonService.start(lessonID);
        return ResponseEntity.ok(res);
    }

    // Stop
    @PostMapping(URLConst.STOP_LESSON)
    public ResponseEntity<?> stopLesson(@Validated @PathVariable("lesson_id") String lessonID) {
        Object res = accountCourseLessonService.stop(lessonID);
        return ResponseEntity.ok(res);
    }

    // Finish
    @PostMapping(URLConst.FINISH_LESSON)
    public ResponseEntity<?> finishLesson(@Validated @PathVariable("lesson_id") String lessonID) {
        Object res = accountCourseLessonService.finish(lessonID);
        return ResponseEntity.ok(res);
    }
}
