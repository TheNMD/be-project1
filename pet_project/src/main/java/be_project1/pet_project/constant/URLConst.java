package be_project1.pet_project.constant;

public class URLConst {
    public static final String LOGIN   = "/login";
    public static final String LOGOUT  = "/logout/{user_id}";

    public static final String CREATE_ADMIN = "/admin/create";
    public static final String READ_ADMIN  = "/admin/read";
    public static final String UPDATE_ADMIN = "/admin/update/{user_id}";
    public static final String DELETE_ADMIN = "/admin/delete/{user_id}";

    public static final String CREATE_USER = "/user/create";
    public static final String READ_USER   = "/user/read";
    public static final String UPDATE_USER = "/user/update/{user_id}";
    public static final String DELETE_USER = "/user/delete/{user_id}";

    public static final String CREATE_COURSE = "/course/create";
    public static final String READ_COURSE   = "/course/read";
    public static final String UPDATE_COURSE = "/course/update/{course_id}";
    public static final String DELETE_COURSE = "/course/delete/{course_id}";

    public static final String CREATE_CHAPTER = "/chapter/create";
    public static final String READ_CHAPTER   = "/chapter/read";
    public static final String UPDATE_CHAPTER = "/chapter/update/{chapter_id}";
    public static final String DELETE_CHAPTER = "/chapter/delete/{chapter_id}";

    public static final String CREATE_LESSON = "/lesson/create";
    public static final String READ_LESSON   = "/lesson/read";
    public static final String UPDATE_LESSON = "/lesson/update/{lesson_id}";
    public static final String DELETE_LESSON = "/lesson/delete/{lesson_id}";

    public static final String CREATE_USER_COURSE = "/user/create_user_course";
    public static final String READ_USER_COURSE   = "/user/read_user_course";
    public static final String UPDATE_USER_COURSE = "/user/update_user_course/{course_id}";
    public static final String DELETE_USER_COURSE = "/user/delete_user_course/{course_id}";
    public static final String VIEW_COURSE           = "/user/view/{course_id}";
    public static final String JOIN_COURSE           = "/user/join/{course_id}";
    public static final String RATE_COURSE           = "/user/rate/{course_id}";
    public static final String REVIEW_COURSE         = "/user/review/{course_id}";

    public static final String CREATE_USER_COURSE_LESSON = "/user/create_user_course_lesson";
    public static final String READ_USER_COURSE_LESSON   = "/user/read_user_course_lesson";
    public static final String UPDATE_USER_COURSE_LESSON = "/user/update_user_course_lesson/{lesson_id}";
    public static final String DELETE_USER_COURSE_LESSON = "/user/delete_user_course_lesson/{lesson_id}";
    public static final String START_LESSON                 = "/user/start/{lesson_id}";
    public static final String STOP_LESSON                  = "/user/stop/{lesson_id}";
    public static final String FINISH_LESSON                = "/user/finish/{lesson_id}";

    private URLConst() {}
}
