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

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.dto.request.AccountReq;
import be_project1.pet_project.dto.request.CourseReq;
import be_project1.pet_project.dto.request.ChapterReq;
import be_project1.pet_project.dto.request.LessonReq;

@RestController("adminController")
@RequestMapping("/api/v1/admin")
public class AdminController {
    // Init
    private final AccountService accountService;
    private final CourseService courseService;
    private final ChapterService chapterService;
    private final LessonService lessonService;

    @Autowired
    public AdminController(@Qualifier("accountServiceImpl") AccountService accountService,
                           @Qualifier("courseServiceImpl") CourseService courseService,
                           @Qualifier("chapterServiceImpl") ChapterService chapterService,
                           @Qualifier("lessonServiceImpl") LessonService lessonService) {
        this.accountService = accountService;
        this.courseService = courseService;
        this.chapterService = chapterService;
        this.lessonService = lessonService;
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
    @GetMapping(URLConst.SEARCH_ACCOUNT)
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

    // Create
    @PostMapping(URLConst.CREATE_COURSE)
    public Object createCourse(@RequestBody CourseReq request) {
        return courseService.create(request);
    }

    // Read
    @GetMapping(URLConst.SEARCH_COURSE)
    public Object readCourse(@RequestParam("sort") String sort,
                             @RequestParam("page") int page,
                             @RequestParam("size") int size,
                             @RequestBody CourseReq request) {
        return courseService.read(sort, page, size, request);
    }

     // Update
     @PutMapping(URLConst.UPDATE_COURSE)
     public Object updateCourse(@PathVariable("course_id") String courseID,
                                @RequestBody CourseReq request) {
         return courseService.update(courseID, request);
     }

    // Delete
    @DeleteMapping(URLConst.DELETE_COURSE)
    public Object deleteCourse(@PathVariable("course_id") String courseID) {
        return courseService.delete(courseID);
    }

    // View
    @GetMapping(URLConst.VIEW_COURSE)
    public Object viewCourse(@PathVariable("course_id") String courseID) {
        return courseService.view(courseID);
    }

    // Join
    @PostMapping(URLConst.JOIN_COURSE)
    public Object joinCourse(@PathVariable("course_id") String courseID) {
        return courseService.join(courseID);
    }

    // Rate
    @PostMapping(URLConst.RATE_COURSE)
    public Object rateCourse(@PathVariable("course_id") String courseID,
                             @RequestBody CourseReq request) {
        return courseService.rate(courseID, request);
    }

    // Review
    @PostMapping(URLConst.REVIEW_COURSE)
    public Object reviewCourse(@PathVariable("course_id") String courseID,
                               @RequestBody CourseReq request) {
        return courseService.review(courseID, request);
    }

    // Chapter

    // Create
    @PostMapping(URLConst.CREATE_CHAPTER)
    public Object createChapter(@RequestBody ChapterReq request) {
        return chapterService.create(request);
    }

    // Read
    @GetMapping(URLConst.SEARCH_CHAPTER)
    public Object readChapter(@RequestParam("sort") String sort,
                              @RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestBody ChapterReq request) {
        return chapterService.read(sort, page, size, request);
    }

     // Update
     @PutMapping(URLConst.UPDATE_CHAPTER)
     public Object updateChapter(@PathVariable("chapter_id") String chapterID,
                                 @RequestBody ChapterReq request) {
         return chapterService.update(chapterID, request);
     }

    // Delete
    @DeleteMapping(URLConst.DELETE_CHAPTER)
    public Object deleteChapter(@PathVariable("chapter_id") String chapterID) {
        return chapterService.delete(chapterID);
    }

    // Lesson

    // Create
    @PostMapping(URLConst.CREATE_LESSON)
    public Object createLesson(@RequestBody LessonReq request) {
        return lessonService.create(request);
    }

    // Read
    @GetMapping(URLConst.SEARCH_LESSON)
    public Object readChapter(@RequestParam("sort") String sort,
                              @RequestParam("page") int page,
                              @RequestParam("size") int size,
                              @RequestBody LessonReq request) {
        return lessonService.read(sort, page, size, request);
    }

     // Update
    @PutMapping(URLConst.UPDATE_LESSON)
    public Object updateLesson(@PathVariable("lesson_id") String lessonID,
                               @RequestBody LessonReq request) {
        return lessonService.update(lessonID, request);
    }

    // Delete
    @DeleteMapping(URLConst.DELETE_LESSON)
    public Object deleteLesson(@PathVariable("lesson_id") String lessonID) {
        return lessonService.delete(lessonID);
    }

    // Begin
    @PostMapping(URLConst.BEGIN_LESSON)
    public Object beginLesson(@PathVariable("lesson_id") String lessonID) {
        return lessonService.begin(lessonID);
    }

    // Stop
    @PostMapping(URLConst.STOP_LESSON)
    public Object stopLesson(@PathVariable("lesson_id") String lessonID) {
        return lessonService.stop(lessonID);
    }

    // Finish
    @PostMapping(URLConst.FINISH_LESSON)
    public Object finishLesson(@PathVariable("lesson_id") String lessonID) {
        return lessonService.finish(lessonID);
    }
}
