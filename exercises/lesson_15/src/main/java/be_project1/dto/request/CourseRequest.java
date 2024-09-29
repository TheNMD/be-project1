package be_project1.lesson_15.dto.request;

public class CourseRequest {
    private String courseName;

    public CourseRequest() {}

    public CourseRequest(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
