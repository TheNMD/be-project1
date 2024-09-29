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

public class LessonManageReq {
    private String lessonName;
    private String chapterName;
    private String courseName;
    private String type;
    private String status;
    private String createdDate;

    public LessonManageReq() {}

    public LessonManageReq(String lessonName,
                           String chapterName,
                           String courseName,
                           String type,
                           String status,
                           String createdDate) {
        this.lessonName = lessonName;
        this.chapterName = chapterName;
        this.courseName = courseName;
        this.type = type;
        this.status = status;
        this.createdDate = createdDate;
    }

    public String getLessonName() {
        return this.lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    public String getChapterName() {
        return this.chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
