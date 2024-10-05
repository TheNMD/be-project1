package be_project1.pet_project.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

import be_project1.pet_project.controller.UserController;
import be_project1.pet_project.controller.CourseController;
import be_project1.pet_project.controller.ChapterController;
import be_project1.pet_project.controller.LessonController;
import be_project1.pet_project.service.ChapterService;
import be_project1.pet_project.service.CourseService;
import be_project1.pet_project.service.LessonService;
import be_project1.pet_project.service.UserService;

@Configuration
public class BeanConfig {
    // Controller
    @Bean
    public UserController userController() {
        return new UserController();
    }

    @Bean
    public CourseController courseController() {
        return new CourseController();
    }

    @Bean
    public ChapterController chapterController() {
        return new ChapterController();
    }
    
    @Bean
    public LessonController lessonController() {
        return new LessonController();
    }

    // Service
    @Bean
    public UserService userService() {
        return new UserService();
    }

    @Bean
    public CourseService courseService() {
        return new CourseService();
    }

    @Bean
    public ChapterService chapterService() {
        return new ChapterService();
    }

    @Bean
    public LessonService lessonService() {
        return new LessonService();
    }

    // Repository
}
