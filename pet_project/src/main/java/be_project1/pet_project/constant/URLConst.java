package be_project1.pet_project.constant;

public class URLConst {
    public static final String LOGIN   = "/account/login";
    public static final String LOGOUT  = "/account/logout/{user_id}";

    public static final String CREATE_ACCOUNT = "/account/create";
    public static final String DELETE_ACCOUNT = "/account/delete/{user_id}";
    public static final String UPDATE_ACCOUNT = "/account/update/{user_id}";
    public static final String SEARCH_ACCOUNT = "/account/search";

    public static final String CREATE_COURSE = "/course/create";
    public static final String DELETE_COURSE = "/course/delete/{course_id}";
    public static final String UPDATE_COURSE = "/course/update/{course_id}";
    public static final String SEARCH_COURSE = "/course/search";
    public static final String VIEW_COURSE   = "/course/view/{course_id}";
    public static final String JOIN_COURSE   = "/course/join/{course_id}";
    public static final String RATE_COURSE   = "/course/rate/{course_id}";
    public static final String REVIEW_COURSE = "/course/review/{course_id}";

    public static final String CREATE_CHAPTER = "/chapter/create";
    public static final String DELETE_CHAPTER = "/chapter/delete/{chapter_id}";
    public static final String UPDATE_CHAPTER = "/chapter/update/{chapter_id}";
    public static final String SEARCH_CHAPTER = "/chapter/search";

    public static final String CREATE_LESSON = "/lesson/create";
    public static final String DELETE_LESSON = "/lesson/delete/{lesson_id}";
    public static final String UPDATE_LESSON = "/lesson/update/{lesson_id}";
    public static final String SEARCH_LESSON = "/lesson/search";
    public static final String BEGIN_LESSON  = "/lesson/begin/{lesson_id}";
    public static final String STOP_LESSON   = "/lesson/stop/{lesson_id}";
    public static final String FINISH_LESSON = "/lesson/finish/{lesson_id}";

    private URLConst() {}
}
