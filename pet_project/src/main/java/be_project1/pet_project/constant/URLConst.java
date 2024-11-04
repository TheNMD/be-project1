package be_project1.pet_project.constant;

public class URLConst {
    public static final String LOGIN_ADMIN  = "/admin/login";
    public static final String LOGOUT_ADMIN = "/admin/logout/{id}";
    public static final String CREATE_ADMIN = "/admin/create";
    public static final String READ_ADMIN   = "/admin/read";
    public static final String UPDATE_ADMIN = "/admin/update/{id}";
    public static final String DELETE_ADMIN = "/admin/delete/{id}";

    public static final String LOGIN_TEACHER  = "/teacher/login";
    public static final String LOGOUT_TEACHER = "/teacher/logout/{id}";
    public static final String CREATE_TEACHER = "/teacher/create";
    public static final String READ_TEACHER   = "/teacher/read";
    public static final String UPDATE_TEACHER = "/teacher/update/{id}";
    public static final String DELETE_TEACHER = "/teacher/delete/{id}";

    public static final String LOGIN_USER  = "/user/login";
    public static final String LOGOUT_USER = "/user/logout/{id}";
    public static final String CREATE_USER = "/user/create";
    public static final String READ_USER   = "/user/read";
    public static final String UPDATE_USER = "/user/update/{id}";
    public static final String DELETE_USER = "/user/delete/{id}";

    public static final String CREATE_COURSE = "/course/create";
    public static final String READ_COURSE   = "/course/read";
    public static final String UPDATE_COURSE = "/course/update/{id}";
    public static final String DELETE_COURSE = "/course/delete/{id}";

    public static final String CREATE_CHAPTER = "/chapter/create";
    public static final String READ_CHAPTER   = "/chapter/read";
    public static final String UPDATE_CHAPTER = "/chapter/update/{id}";
    public static final String DELETE_CHAPTER = "/chapter/delete/{id}";

    public static final String CREATE_LESSON = "/lesson/create";
    public static final String READ_LESSON   = "/lesson/read";
    public static final String UPDATE_LESSON = "/lesson/update/{id}";
    public static final String DELETE_LESSON = "/lesson/delete/{id}";

    public static final String CREATE_USER_COURSE = "/user/{userId}/course/create";
    public static final String READ_USER_COURSE   = "/user/{userId}/course/read";
    public static final String UPDATE_USER_COURSE = "/user/{userId}/course/update/{courseId}";
    public static final String DELETE_USER_COURSE = "/user/{userId}/course/delete/{courseId}";
    public static final String VIEW_COURSE        = "/user/{userId}/course/view/{courseId}";
    public static final String JOIN_COURSE        = "/user/{userId}/course/join/{courseId}";
    public static final String RATE_COURSE        = "/user/{userId}/course/rate/{courseId}";
    public static final String REVIEW_COURSE      = "/user/{userId}/course/review/{courseId}";

    public static final String CREATE_USER_COURSE_LESSON = "/user/{userId}/course/{courseId}/lesson/create";
    public static final String READ_USER_COURSE_LESSON   = "/user/{userId}/course/{courseId}/lesson/read";
    public static final String UPDATE_USER_COURSE_LESSON = "/user/{userId}/course/{courseId}/lesson/update/{lessonId}";
    public static final String DELETE_USER_COURSE_LESSON = "/user/{userId}/course/{courseId}/lesson/delete/{lessonId}";
    public static final String START_LESSON              = "/user/{userId}/course/{courseId}/lesson/start/{lessonId}";
    public static final String STOP_LESSON               = "/user/{userId}/course/{courseId}/lesson/stop/{lessonId}";
    public static final String FINISH_LESSON             = "/user/{userId}/course/{courseId}/lesson/finish/{lessonId}";

    private URLConst() {}
}
