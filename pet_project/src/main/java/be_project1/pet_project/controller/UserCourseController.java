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
        @PathVariable("userID") int userID,
        @RequestBody UserCourseCreateReq request
        ) {
        Object res = userCourseService.create(userID, request);
        return ResponseEntity.ok(res);
    }

    // Read
    @PostMapping(URLConst.READ_USER_COURSE)
    public ResponseEntity<?> readUserCourse(
        @Validated
        @PathVariable("userID") int userID,
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody UserCourseReadReq request
        ) {
        Object res = userCourseService.read(userID, sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_USER_COURSE)
    public ResponseEntity<?> updateUserCourse(
        @Validated
        @PathVariable("userID") int userID,
        @PathVariable("courseID") int courseID,
        @RequestBody UserCourseUpdateReq request
        ) {
        Object res = userCourseService.update(userID, courseID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_USER_COURSE)
    public ResponseEntity<?> deleteUserCourse(
        @Validated
        @PathVariable("userID") int userID,
        @PathVariable("courseID") int courseID
        ) {
        Object res = userCourseService.delete(userID, courseID);
        return ResponseEntity.ok(res);
    }

    // // View
    // @PostMapping(URLConst.VIEW_COURSE)
    // public ResponseEntity<?> viewCourse(@Validated @PathVariable("courseID") int courseID) {
    //     Object res = userCourseService.view(courseID);
    //     return ResponseEntity.ok(res);
    // }

    // // Join
    // @PostMapping(URLConst.JOIN_COURSE)
    // public ResponseEntity<?> joinCourse(@Validated @PathVariable("courseID") int courseID) {
    //     Object res = userCourseService.join(courseID);
    //     return ResponseEntity.ok(res);
    // }

    // // Rate
    // @PostMapping(URLConst.RATE_COURSE)
    // public ResponseEntity<?> rateCourse(
    //     @Validated
    //     @PathVariable("courseID") int courseID,
    //     @RequestBody UserCourseCreateReq request) {
    //     Object res = userCourseService.rate(courseID, request);
    //     return ResponseEntity.ok(res);
    // }

    // // Review
    // @PostMapping(URLConst.REVIEW_COURSE)
    // public ResponseEntity<?> reviewCourse(
    //     @Validated
    //     @PathVariable("courseID") int courseID,
    //     @RequestBody UserCourseCreateReq request) {
    //     Object res = userCourseService.review(courseID, request);
    //     return ResponseEntity.ok(res);
    // }
}
