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
import be_project1.pet_project.service.UserCourseLessonService;
import be_project1.pet_project.dto.request.UserCourseLessonCreateReq;
import be_project1.pet_project.dto.request.UserCourseLessonReadReq;
import be_project1.pet_project.dto.request.UserCourseLessonUpdateReq;

@RestController("userCourseLessonController")
@RequestMapping("/api/v1")
public class UserCourseLessonController {
    // Init
    private final UserCourseLessonService userCourseLessonService;

    @Autowired
    public UserCourseLessonController(@Qualifier("userCourseLessonServiceImpl") UserCourseLessonService userCourseLessonService) {
        this.userCourseLessonService = userCourseLessonService;
    }

    // Create
    @PostMapping(URLConst.CREATE_USER_COURSE_LESSON)
    public ResponseEntity<?> createUserCourseLesson(
        @Validated
        @PathVariable("userId") int userId,
        @PathVariable("courseId") int courseId,
        @RequestBody UserCourseLessonCreateReq request
        ) {
        Object response = userCourseLessonService.create(userId, courseId, request);
        return ResponseEntity.ok(response);
    }

    // Read
    @PostMapping(URLConst.READ_USER_COURSE_LESSON)
    public ResponseEntity<?> readUserCourseLesson(
        @Validated
        @PathVariable("userId") int userId,
        @PathVariable("courseId") int courseId,
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody UserCourseLessonReadReq request
        ) {
        Object response = userCourseLessonService.read(userId, courseId, sort, page, size, request);
        return ResponseEntity.ok(response);
    }

     // Update
    @PutMapping(URLConst.UPDATE_USER_COURSE_LESSON)
    public ResponseEntity<?> updateUserCourseLesson(
        @Validated
        @PathVariable("userId") int userId,
        @PathVariable("courseId") int courseId,
        @PathVariable("lessonId") int lessonId,
        @RequestBody UserCourseLessonUpdateReq request
        ) {
        Object response = userCourseLessonService.update(userId, courseId, lessonId, request);
        return ResponseEntity.ok(response);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_USER_COURSE_LESSON)
    public ResponseEntity<?> deleteUserCourseLesson(
        @Validated
        @PathVariable("userId") int userId,
        @PathVariable("courseId") int courseId,
        @PathVariable("lessonId") int lessonId
        ) {
        Object response = userCourseLessonService.delete(userId, courseId, lessonId);
        return ResponseEntity.ok(response);
    }

    // // Start
    // @PostMapping(URLConst.START_LESSON)
    // public ResponseEntity<?> startLesson(@Validated @PathVariable("lessonId") String lessonId) {
    //     Object response = userCourseLessonService.start(lessonId);
    //     return ResponseEntity.ok(response);
    // }

    // // Stop
    // @PostMapping(URLConst.STOP_LESSON)
    // public ResponseEntity<?> stopLesson(@Validated @PathVariable("lessonId") String lessonId) {
    //     Object response = userCourseLessonService.stop(lessonId);
    //     return ResponseEntity.ok(response);
    // }

    // // Finish
    // @PostMapping(URLConst.FINISH_LESSON)
    // public ResponseEntity<?> finishLesson(@Validated @PathVariable("lessonId") String lessonId) {
    //     Object response = userCourseLessonService.finish(lessonId);
    //     return ResponseEntity.ok(response);
    // }
}
