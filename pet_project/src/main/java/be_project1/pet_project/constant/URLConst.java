package be_project1.pet_project.constant;

public class URLConst {
    public static final String LOGIN   = "/login";
    public static final String LOGOUT  = "/logout/{user_id}";

    public static final String CREATE_ACCOUNT = "/account/create";
    public static final String READ_ACCOUNT   = "/account/read";
    public static final String UPDATE_ACCOUNT = "/account/update/{user_id}";
    public static final String DELETE_ACCOUNT = "/account/delete/{user_id}";

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

    public static final String CREATE_ACCOUNT_COURSE = "/account/create_account_course";
    public static final String READ_ACCOUNT_COURSE   = "/account/read_account_course";
    public static final String UPDATE_ACCOUNT_COURSE = "/account/update_account_course/{course_id}";
    public static final String DELETE_ACCOUNT_COURSE = "/account/delete_account_course/{course_id}";
    public static final String VIEW_COURSE           = "/account/view/{course_id}";
    public static final String JOIN_COURSE           = "/account/join/{course_id}";
    public static final String RATE_COURSE           = "/account/rate/{course_id}";
    public static final String REVIEW_COURSE         = "/account/review/{course_id}";

    public static final String CREATE_ACCOUNT_COURSE_LESSON = "/account/create_account_course_lesson";
    public static final String READ_ACCOUNT_COURSE_LESSON   = "/account/read_account_course_lesson";
    public static final String UPDATE_ACCOUNT_COURSE_LESSON = "/account/update_account_course_lesson/{lesson_id}";
    public static final String DELETE_ACCOUNT_COURSE_LESSON = "/account/delete_account_course_lesson/{lesson_id}";
    public static final String START_LESSON                 = "/account/start/{lesson_id}";
    public static final String STOP_LESSON                  = "/account/stop/{lesson_id}";
    public static final String FINISH_LESSON                = "/account/finish/{lesson_id}";

    private URLConst() {}
}
