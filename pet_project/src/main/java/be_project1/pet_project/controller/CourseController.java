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
    public Object createCourse(@RequestBody CourseCreateReq request) {
        return courseService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_COURSE)
    public Object readCourse(@RequestParam("sort") String sort,
                             @RequestParam("page") int page,
                             @RequestParam("size") int size,
                             @RequestBody CourseReadReq request) {
        return courseService.read(sort, page, size, request);
    }

    // Update
    @PutMapping(URLConst.UPDATE_COURSE)
    public Object updateCourse(@PathVariable("course_id") String courseID,
                            @RequestBody CourseUpdateReq request) {
        return courseService.update(courseID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_COURSE)
    public Object deleteCourse(@PathVariable("course_id") String courseID) {
        return courseService.delete(courseID);
    }
}
