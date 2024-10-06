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

import be_project1.pet_project.service.AccountService;
import be_project1.pet_project.service.CourseService;
import be_project1.pet_project.service.ChapterService;
import be_project1.pet_project.service.LessonService;
import be_project1.pet_project.service.AccountCourseService;
import be_project1.pet_project.service.AccountCourseLessonService;

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.dto.request.AccountReq;
import be_project1.pet_project.dto.request.CourseReq;
import be_project1.pet_project.dto.request.ChapterReq;
import be_project1.pet_project.dto.request.LessonReq;
import be_project1.pet_project.dto.request.AccountCourseReq;
import be_project1.pet_project.dto.request.AccountCourseLessonReq;

@RestController("userController")
@RequestMapping("/api/v1/user")
public class UserController {
    // Init
    private final AccountService accountService;
    private final CourseService courseService;
    private final ChapterService chapterService;
    private final LessonService lessonService;
    private final AccountCourseService accountCourseService;
    private final AccountCourseLessonService accountCourseLessonService;

    @Autowired
    public UserController(@Qualifier("accountServiceImpl") AccountService accountService,
                          @Qualifier("courseServiceImpl") CourseService courseService,
                          @Qualifier("chapterServiceImpl") ChapterService chapterService,
                          @Qualifier("lessonServiceImpl") LessonService lessonService,
                          @Qualifier("accountCourseServiceImpl") AccountCourseService accountCourseService,
                          @Qualifier("accountCourseLessonServiceImpl") AccountCourseLessonService accountCourseLessonService) {
        this.accountService = accountService;
        this.courseService = courseService;
        this.chapterService = chapterService;
        this.lessonService = lessonService;
        this.accountCourseService = accountCourseService;
        this.accountCourseLessonService = accountCourseLessonService;
    }

    // Test
    @GetMapping("/test")
    public String test() {
        return "Test endpoint is working!";
    }

    // Accounts

    // Login
    @PostMapping(URLConst.LOGIN)
    public Object login(@RequestBody AccountReq request) {
        return accountService.login(request);
    }

    // Logout
    @PostMapping(URLConst.LOGOUT)
    public Object logout(@PathVariable("user_id") String accountID) {
        return accountService.logout(accountID);
    }

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT)
    public Object createAccount(@RequestBody AccountReq request) {
        return accountService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT)
    public Object readAccount(@RequestParam("sort") String sort,
                              @RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestBody AccountReq request) {
        return accountService.read(sort, page, size, request);
    }

     // Update
    @PutMapping(URLConst.UPDATE_ACCOUNT)
    public Object updateAccount(@PathVariable("user_id") String accountID,
                                @RequestBody AccountReq request) {
        return accountService.update(accountID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT)
    public Object deleteAccount(@PathVariable("user_id") String accountID) {
        return accountService.delete(accountID);
    }

    // Courses

    // Read
    @GetMapping(URLConst.READ_COURSE)
    public Object readCourse(@RequestParam("sort") String sort,
                             @RequestParam("page") int page,
                             @RequestParam("size") int size,
                             @RequestBody CourseReq request) {
        return courseService.read(sort, page, size, request);
    }

    // Chapter

    // Read
    @GetMapping(URLConst.READ_CHAPTER)
    public Object readChapter(@RequestParam("sort") String sort,
                              @RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestBody ChapterReq request) {
        return chapterService.read(sort, page, size, request);
    }

    // Lesson

    // Read
    @GetMapping(URLConst.READ_LESSON)
    public Object readChapter(@RequestParam("sort") String sort,
                              @RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestBody LessonReq request) {
        return lessonService.read(sort, page, size, request);
    }

    // AccountCourse

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT_COURSE)
    public Object createAccountCourse(@RequestBody AccountCourseReq request) {
        return accountCourseService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT_COURSE)
    public Object readAccountCourse(@RequestParam("sort") String sort,
                                    @RequestParam("page") int page,
                                    @RequestParam("size") int size,
                                    @RequestBody AccountCourseReq request) {
        return accountCourseService.read(sort, page, size, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT_COURSE)
    public Object deleteAccountCourse(@PathVariable("course_id") String courseID) {
        return accountCourseService.delete(courseID);
    }

    // View
    @GetMapping(URLConst.VIEW_COURSE)
    public Object viewCourse(@PathVariable("course_id") String courseID) {
        return accountCourseService.view(courseID);
    }

    // Join
    @PostMapping(URLConst.JOIN_COURSE)
    public Object joinCourse(@PathVariable("course_id") String courseID) {
        return accountCourseService.join(courseID);
    }

    // Rate
    @PostMapping(URLConst.RATE_COURSE)
    public Object rateCourse(@PathVariable("course_id") String courseID,
                             @RequestBody AccountCourseReq request) {
        return accountCourseService.rate(courseID, request);
    }

    // Review
    @PostMapping(URLConst.REVIEW_COURSE)
    public Object reviewCourse(@PathVariable("course_id") String courseID,
                               @RequestBody AccountCourseReq request) {
        return accountCourseService.review(courseID, request);
    }

    // AccountCourseLesson

    // Create
    @PostMapping(URLConst.CREATE_ACCOUNT_COURSE_LESSON)
    public Object createAccountCourseLesson(@RequestBody AccountCourseLessonReq request) {
        return accountCourseLessonService.create(request);
    }

    // Read
    @GetMapping(URLConst.READ_ACCOUNT_COURSE_LESSON)
    public Object readAccountCourseLesson(@RequestParam("sort") String sort,
                                          @RequestParam("page") int page,
                                          @RequestParam("size") int size,
                                          @RequestBody AccountCourseLessonReq request) {
        return accountCourseLessonService.read(sort, page, size, request);
    }

     // Update
     @PutMapping(URLConst.UPDATE_ACCOUNT_COURSE_LESSON)
     public Object updateAccountCourseLesson(@PathVariable("course_id") String courseID,
                                             @RequestBody AccountCourseLessonReq request) {
         return accountCourseLessonService.update(courseID, request);
     }

    // Delete
    @DeleteMapping(URLConst.DELETE_ACCOUNT_COURSE_LESSON)
    public Object deleteAccountCourseLesson(@PathVariable("course_id") String courseID) {
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
