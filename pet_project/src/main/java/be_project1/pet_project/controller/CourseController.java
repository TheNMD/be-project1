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
import be_project1.pet_project.service.CourseService;
import be_project1.pet_project.dto.request.CourseCreateReq;
import be_project1.pet_project.dto.request.CourseReadReq;
import be_project1.pet_project.dto.request.CourseUpdateReq;

@RestController("courseController")
@RequestMapping("/api/v1")
public class CourseController {
    // Init
    private final CourseService courseService;

    @Autowired
    public CourseController(@Qualifier("courseServiceImpl") CourseService courseService) {
        this.courseService = courseService;
    }

    // Create
    @PostMapping(URLConst.CREATE_COURSE)
    public ResponseEntity<?> createCourse(@Validated @RequestBody CourseCreateReq request) {
        Object res = courseService.create(request);
        return ResponseEntity.ok(res);
    }

    // Read
    @GetMapping(URLConst.READ_COURSE)
    public ResponseEntity<?> readCourse(
        @Validated
        @RequestParam("sort") String sort,
        @RequestParam("page") int page,
        @RequestParam("size") int size,
        @RequestBody CourseReadReq request) {
        Object res = courseService.read(sort, page, size, request);
        return ResponseEntity.ok(res);
    }

    // Update
    @PutMapping(URLConst.UPDATE_COURSE)
    public ResponseEntity<?> updateCourse(
        @Validated
        @PathVariable("course_id") String courseID,
        @RequestBody CourseUpdateReq request) {
        Object res = courseService.update(courseID, request);
        return ResponseEntity.ok(res);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_COURSE)
    public ResponseEntity<?> deleteCourse(@Validated @PathVariable("course_id") String courseID) {
        Object res = courseService.delete(courseID);
        return ResponseEntity.ok(res);
    }
}
