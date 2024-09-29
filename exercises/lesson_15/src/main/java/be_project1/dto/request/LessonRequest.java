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
