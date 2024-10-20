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
import be_project1.pet_project.service.AccountCourseService;
import be_project1.pet_project.dto.request.AccountCourseCreateReq;
import be_project1.pet_project.dto.request.AccountCourseReadReq;
import be_project1.pet_project.dto.request.AccountCourseUpdateReq;
import be_project1.pet_project.dto.request.AccountCourseRateReq;
import be_project1.pet_project.dto.request.AccountCourseReviewReq;

@RestController("accountCourseController")
@RequestMapping("/api/v1")
public class AccountCourseController {
    // Init
    private final AccountCourseService accountCourseService;

    @Autowired
    public AccountCourseController(@Qualifier("accountCourseServiceImpl") AccountCourseService accountCourseService) {
        this.accountCourseService = accountCourseService;
    }

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT_COURSE)
    public ResponseEntity<?> createAccountCourse(@Validated @RequestBody AccountCourseCreateReq request) {
        Object res = accountCourseService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT_COURSE)
    public ResponseEntity<?> readAccountCourse(
        @Validated
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody AccountCourseReadReq request) {
        Object res = accountCourseService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_ACCOUNT_COURSE)
    public ResponseEntity<?> updateAccountCourse(
        @Validated
        @PathVariable("course_id") String courseID,
        @RequestBody AccountCourseUpdateReq request) {
        Object res = accountCourseService.update(courseID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT_COURSE)
    public ResponseEntity<?> deleteAccountCourse(@Validated @PathVariable("course_id") String courseID) {
        Object res = accountCourseService.delete(courseID);
        return ResponseEntity.ok(res);
    }

    // View
    @GetMapping(URLConst.VIEW_COURSE)
    public ResponseEntity<?> viewCourse(@Validated @PathVariable("course_id") String courseID) {
        Object res = accountCourseService.view(courseID);
        return ResponseEntity.ok(res);
    }

    // Join
    @PostMapping(URLConst.JOIN_COURSE)
    public ResponseEntity<?> joinCourse(@Validated @PathVariable("course_id") String courseID) {
        Object res = accountCourseService.join(courseID);
        return ResponseEntity.ok(res);
    }

    // Rate
    @PostMapping(URLConst.RATE_COURSE)
    public ResponseEntity<?> rateCourse(
        @Validated
        @PathVariable("course_id") String courseID,
        @RequestBody AccountCourseRateReq request) {
        Object res = accountCourseService.rate(courseID, request);
        return ResponseEntity.ok(res);
    }

    // Review
    @PostMapping(URLConst.REVIEW_COURSE)
    public ResponseEntity<?> reviewCourse(
        @Validated
        @PathVariable("course_id") String courseID,
        @RequestBody AccountCourseReviewReq request) {
        Object res = accountCourseService.review(courseID, request);
        return ResponseEntity.ok(res);
    }
}
