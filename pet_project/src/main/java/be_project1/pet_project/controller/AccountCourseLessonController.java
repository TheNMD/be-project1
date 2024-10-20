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

    // AccountCourseLesson

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT_COURSE_LESSON)
    public Object createAccountCourseLesson(@RequestBody AccountCourseLessonCreateReq request) {
        return accountCourseLessonService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT_COURSE_LESSON)
    public Object readAccountCourseLesson(@RequestParam("sort") String sort,
                                          @RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestBody AccountCourseLessonReadReq request) {
        return accountCourseLessonService.read(sort, page, size, request);
    }

     // Update
    @PutMapping(URLConst.UPDATE_ACCOUNT_COURSE_LESSON)
    public Object updateAccountCourseLesson(@PathVariable("lesson_id") String courseID,
                                            @RequestBody AccountCourseLessonUpdateReq request) {
        return accountCourseLessonService.update(courseID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT_COURSE_LESSON)
    public Object deleteAccountCourseLesson(@PathVariable("lesson_id") String courseID) {
        return accountCourseLessonService.delete(courseID);
    }

    // Start
    @PostMapping(URLConst.START_LESSON)
    public Object startLesson(@PathVariable("lesson_id") String lessonID) {
        return accountCourseLessonService.start(lessonID);
    }

    // Stop
    @PostMapping(URLConst.STOP_LESSON)
    public Object stopLesson(@PathVariable("lesson_id") String lessonID) {
        return accountCourseLessonService.stop(lessonID);
    }

    // Finish
    @PostMapping(URLConst.FINISH_LESSON)
    public Object finishLesson(@PathVariable("lesson_id") String lessonID) {
        return accountCourseLessonService.finish(lessonID);
    }
}
