package be_project1.lesson_15.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

// @NoArgsConstructor
// @AllArgsConstructor
// @Data
// @SuperBuilder
// @Accessors(chain=true)
// @JsonInclude(JsonInclude.Include.NON_NULL)
// @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class CourseManageReq {
    private String courseName;
    private String teacherName;
    private String status;
    private double rating;
    private String createdDate;

    public CourseManageReq() {}

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return this.teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
