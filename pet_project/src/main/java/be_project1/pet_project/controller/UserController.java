package be_project1.pet_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import be_project1.pet_project.service.AccountService;
import be_project1.pet_project.service.CourseService;
import be_project1.pet_project.service.ChapterService;
import be_project1.pet_project.service.LessonService;

import be_project1.pet_project.constant.URLConst;
import be_project1.pet_project.dto.request.LoginReq;
import be_project1.pet_project.dto.request.AccountManageReq;
import be_project1.pet_project.dto.request.CourseManageReq;
import be_project1.pet_project.dto.request.ChapterManageReq;
import be_project1.pet_project.dto.request.LessonManageReq;


@RestController("userController")
public class UserController {
    
    private final AccountService accountService;
    private final CourseService courseService;
    private final ChapterService chapterService;
    private final LessonService lessonService;

    @Autowired
    public UserController(@Qualifier("accountServiceImpl") AccountService accountService,
                          @Qualifier("courseServiceImpl") CourseService courseService,
                          @Qualifier("chapterServiceImpl") ChapterService chapterService,
                          @Qualifier("lessonsServiceImpl") LessonService lessonService) {
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
    @PostMapping(URLConst.USER_LOGIN)
    public Object login(@RequestBody LoginReq request) {
        return accountService.login(request);
    }

    // Logout
    @PostMapping(URLConst.USER_LOGOUT)
    public Object logout(@PathVariable("user_id") String accountID) {
        return accountService.logout(accountID);
    }

    // Create
    @PostMapping(URLConst.USER_CREATE)
    public Object createAccount(@RequestBody AccountManageReq request) {
        return accountService.create(request);
    }

    // Delete
    @DeleteMapping(URLConst.USER_DELETE)
    public Object deleteAccount(@PathVariable("user_id") String accountID) {
        return accountService.delete(accountID);
    }

     // Update
    @PutMapping(URLConst.USER_UPDATE)
    public Object updateAccount(@PathVariable("user_id") String accountID,
                                @RequestBody AccountManageReq request) {
        return accountService.update(accountID, request);
    }

    // Search
    @PostMapping(URLConst.USER_SEARCH)
    public Object searchAccount(@RequestParam("sort") String sort,
                                @RequestParam("page") int page,
                                @RequestParam("size") int size,
                                @RequestBody AccountManageReq request) {
        return accountService.search(sort, page, size, request);
    }

    // Courses
    // Create course
    @PostMapping(URLConst.COURSE_CREATE)
    public Object createCourse(@RequestBody CourseManageReq request) {
        return courseService.create(request);
    }

    // Delete course
    @DeleteMapping(URLConst.COURSE_DELETE)
    public Object deleteCourse(@PathVariable("course_id") String courseID) {
        return courseService.delete(courseID);
    }

     // Update course
    @PutMapping(URLConst.COURSE_UPDATE)
    public Object updateCourse(@PathVariable("course_id") String courseID, 
                               @RequestBody CourseManageReq request) { 
        return courseService.update(courseID, request);
    }

    // Search course
    @PostMapping(URLConst.COURSE_SEARCH)
    public Object searchCourse(@RequestParam("sort") String sort,
                               @RequestParam("page") int page,
                               @RequestParam("size") int size,
                               @RequestBody CourseManageReq request) {
        return courseService.search(sort, page, size, request);
    }

    // View a course
    @GetMapping(URLConst.COURSE_VIEW)
    public Object viewCourse(@PathVariable("course_id") String courseID) {
        return courseService.view(courseID);
    }

    // Join a course
    @PostMapping(URLConst.JOIN_COURSE)
    public Object joinCourse(@PathVariable("course_id") String courseID) {
        return courseService.join(courseID);
    }

    // Rate a course
    @PostMapping(URLConst.RATE_COURSE)
    public Object rateCourse(@PathVariable("course_id") String courseID, 
                             @RequestBody CourseManageReq request) {
        return courseService.rate(courseID, request);
    }

    // Chapter
    // Create chapter
    @PostMapping(URLConst.CHAPTER_CREATE)
    public Object createChapter(@RequestBody ChapterManageReq request) {
        return chapterService.create(request);
    }

    // Delete chapter
    @DeleteMapping(URLConst.CHAPTER_DELETE)
    public Object deleteChapter(@PathVariable("chapter_id") String chapterID) {
        return chapterService.delete(chapterID);
    }

     // Update chapter
    @PutMapping(URLConst.CHAPTER_UPDATE)
    public Object updateChapter(@PathVariable("chapter_id") String chapterID,
                                @RequestBody ChapterManageReq request) {
        return chapterService.update(chapterID, request);
    }

    // Search chapter
    @PostMapping(URLConst.CHAPTER_SEARCH)
    public Object searchChapter(@RequestParam("sort") String sort,
                                @RequestParam("page") int page,
                                @RequestParam("size") int size,
                                @RequestBody ChapterManageReq request) {
        return chapterService.search(sort, page, size, request);
    }

    // Lesson
    // Create lesson
    @PostMapping(URLConst.LESSON_CREATE)
    public Object createLesson(@RequestBody LessonManageReq request) {
        return lessonService.create(request);
    }

    // Delete lesson
    @DeleteMapping(URLConst.LESSON_DELETE)
    public Object deleteLesson(@PathVariable("lesson_id") String lessonID) {
        return lessonService.delete(lessonID);
    }

     // Update lesson
    @PutMapping(URLConst.LESSON_UPDATE)
    public Object updateLesson(@PathVariable("lesson_id") String lessonID,
                               @RequestBody LessonManageReq request) {
        return lessonService.update(lessonID, request);
    }

    // Search lesson
    @PostMapping(URLConst.LESSON_SEARCH)
    public Object searchChapter(@RequestParam("sort") String sort,
                                @RequestParam("page") int page,
                                @RequestParam("size") int size,
                                @RequestBody LessonManageReq request) {
        return lessonService.search(sort, page, size, request);
    }

    // Begin lesson
    @PostMapping(URLConst.LESSON_BEGIN)
    public Object beginLesson(@PathVariable("lesson_id") String lessonID) {
        return lessonService.begin(lessonID);
    }

    // Resume lesson
    @PostMapping(URLConst.LESSON_RESUME)
    public Object stopLesson(@PathVariable("lesson_id") String lessonID) {
        return lessonService.stop(lessonID);
    }

    // Stop lesson
    @PostMapping(URLConst.LESSON_STOP)
    public Object finishLesson(@PathVariable("lesson_id") String lessonID) {
        return lessonService.finish(lessonID);
    }
}
