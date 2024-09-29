package be_project1.lesson_15.dto.request;

public class LessonRequest {
    private String lessonName;

    public LessonRequest() {}

    public LessonRequest(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getLessonName() {
        return this.lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }
}
