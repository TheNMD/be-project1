package be_project1.lesson_15.constant;

public class URLConst {

    private URLConst() {}

    public static final String USER_CREATE = "/api/v1/user/create";
    public static final String USER_DELETE = "/api/v1/user/delete/{user_id}";
    public static final String USER_UPDATE = "/api/v1/user/update/{user_id}";
    public static final String USER_LOGIN  = "/api/v1/user/login";
    public static final String USER_SEARCH = "/api/v1/user/search";

    public static final String COURSE_CREATE = "/api/v1/course/create";
    public static final String COURSE_DELETE = "/api/v1/course/delete/{course_id}";
    public static final String COURSE_UPDATE = "/api/v1/course/update/{course_id}";
    public static final String COURSE_SEARCH = "/api/v1/course/search";
    public static final String COURSE_VIEW   = "/api/v1/course/view/{course_id}";
    public static final String JOIN_COURSE   = "/api/v1/course/join/{course_id}";
    public static final String RATE_COURSE   = "/api/v1/course/rate/{course_id}";
    public static final String REVIEW_COURSE = "/api/v1/course/review/{course_id}";

    public static final String CHAPTER_CREATE = "/api/v1/chapter/create";
    public static final String CHAPTER_DELETE = "/api/v1/chapter/delete/{chapter_id}";
    public static final String CHAPTER_UPDATE = "/api/v1/chapter/update/{chapter_id}";
    public static final String CHAPTER_SEARCH = "/api/v1/chapter/search";

    public static final String LESSON_CREATE = "/api/v1/lesson/create";
    public static final String LESSON_DELETE = "/api/v1/lesson/delete/{lesson_id}";
    public static final String LESSON_UPDATE = "/api/v1/lesson/update/{lesson_id}";
    public static final String LESSON_SEARCH = "/api/v1/lesson/search";
    public static final String LESSON_BEGIN  = "/api/v1/lesson/begin/{lesson_id}";
    public static final String LESSON_RESUME = "/api/v1/lesson/resume/{lesson_id}";
    public static final String LESSON_STOP   = "/api/v1/lesson/stop/{lesson_id}";
}
