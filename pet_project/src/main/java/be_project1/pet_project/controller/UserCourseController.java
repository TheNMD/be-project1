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
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.service.UserCourseService;
import be_project1.pet_project.dto.request.UserCourseCreateReq;
import be_project1.pet_project.dto.request.UserCourseReadReq;
import be_project1.pet_project.dto.request.UserCourseUpdateReq;

@RestController("userCourseController")
@RequestMapping("/api/v1")
public class UserCourseController {
    // Init
    private final UserCourseService userCourseService;

    @Autowired
    public UserCourseController(@Qualifier("userCourseServiceImpl") UserCourseService userCourseService) {
        this.userCourseService = userCourseService;
    }

    // Create
    @PostMapping(URLConst.CREATE_USER_COURSE)
    public ResponseEntity<?> createUserCourse(
        @Validated
        @PathVariable("userId") int userId,
        @RequestBody UserCourseCreateReq request
        ) {
        Object response = userCourseService.create(userId, request);
        return ResponseEntity.ok(response);
    }

    // Read
    @PostMapping(URLConst.READ_USER_COURSE)
    public ResponseEntity<?> readUserCourse(
        @Validated
        @PathVariable("userId") int userId,
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody UserCourseReadReq request
        ) {
        Object response = userCourseService.read(userId, sort, page, size, request);
        return ResponseEntity.ok(response);
    }

    // Update
    @PutMapping(URLConst.UPDATE_USER_COURSE)
    public ResponseEntity<?> updateUserCourse(
        @Validated
        @PathVariable("userId") int userId,
        @PathVariable("courseId") int courseId,
        @RequestBody UserCourseUpdateReq request
        ) {
        Object response = userCourseService.update(userId, courseId, request);
        return ResponseEntity.ok(response);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_USER_COURSE)
    public ResponseEntity<?> deleteUserCourse(
        @Validated
        @PathVariable("userId") int userId,
        @PathVariable("courseId") int courseId
        ) {
        Object response = userCourseService.delete(userId, courseId);
        return ResponseEntity.ok(response);
    }

    // // View
    // @PostMapping(URLConst.VIEW_COURSE)
    // public ResponseEntity<?> viewCourse(@Validated @PathVariable("courseId") int courseId) {
    //     Object response = userCourseService.view(courseId);
    //     return ResponseEntity.ok(response);
    // }

    // // Join
    // @PostMapping(URLConst.JOIN_COURSE)
    // public ResponseEntity<?> joinCourse(@Validated @PathVariable("courseId") int courseId) {
    //     Object response = userCourseService.join(courseId);
    //     return ResponseEntity.ok(response);
    // }

    // // Rate
    // @PostMapping(URLConst.RATE_COURSE)
    // public ResponseEntity<?> rateCourse(
    //     @Validated
    //     @PathVariable("courseId") int courseId,
    //     @RequestBody UserCourseCreateReq request) {
    //     Object response = userCourseService.rate(courseId, request);
    //     return ResponseEntity.ok(response);
    // }

    // // Review
    // @PostMapping(URLConst.REVIEW_COURSE)
    // public ResponseEntity<?> reviewCourse(
    //     @Validated
    //     @PathVariable("courseId") int courseId,
    //     @RequestBody UserCourseCreateReq request) {
    //     Object response = userCourseService.review(courseId, request);
    //     return ResponseEntity.ok(response);
    // }
}
