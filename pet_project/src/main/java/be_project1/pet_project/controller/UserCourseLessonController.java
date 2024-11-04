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
        @PathVariable("userID") int userID,
        @PathVariable("courseID") int courseID,
        @RequestBody UserCourseLessonCreateReq request
        ) {
        Object res = userCourseLessonService.create(userID, courseID, request);
        return ResponseEntity.ok(res);
    }

    // Read
    @PostMapping(URLConst.READ_USER_COURSE_LESSON)
    public ResponseEntity<?> readUserCourseLesson(
        @Validated
        @PathVariable("userID") int userID,
        @PathVariable("courseID") int courseID,
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody UserCourseLessonReadReq request
        ) {
        Object res = userCourseLessonService.read(userID, courseID, sort, page, size, request);
        return ResponseEntity.ok(res);
    }

     // Update
    @PutMapping(URLConst.UPDATE_USER_COURSE_LESSON)
    public ResponseEntity<?> updateUserCourseLesson(
        @Validated
        @PathVariable("userID") int userID,
        @PathVariable("courseID") int courseID,
        @PathVariable("lessonID") int lessonID,
        @RequestBody UserCourseLessonUpdateReq request
        ) {
        Object res = userCourseLessonService.update(userID, courseID, lessonID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_USER_COURSE_LESSON)
    public ResponseEntity<?> deleteUserCourseLesson(
        @Validated
        @PathVariable("userID") int userID,
        @PathVariable("courseID") int courseID,
        @PathVariable("lessonID") int lessonID
        ) {
        Object res = userCourseLessonService.delete(userID, courseID, lessonID);
        return ResponseEntity.ok(res);
    }

    // // Start
    // @PostMapping(URLConst.START_LESSON)
    // public ResponseEntity<?> startLesson(@Validated @PathVariable("lessonID") String lessonID) {
    //     Object res = userCourseLessonService.start(lessonID);
    //     return ResponseEntity.ok(res);
    // }

    // // Stop
    // @PostMapping(URLConst.STOP_LESSON)
    // public ResponseEntity<?> stopLesson(@Validated @PathVariable("lessonID") String lessonID) {
    //     Object res = userCourseLessonService.stop(lessonID);
    //     return ResponseEntity.ok(res);
    // }

    // // Finish
    // @PostMapping(URLConst.FINISH_LESSON)
    // public ResponseEntity<?> finishLesson(@Validated @PathVariable("lessonID") String lessonID) {
    //     Object res = userCourseLessonService.finish(lessonID);
    //     return ResponseEntity.ok(res);
    // }
}
