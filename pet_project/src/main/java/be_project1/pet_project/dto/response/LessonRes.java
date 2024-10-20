package be_project1.pet_project.dto.response;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain=true)
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class LessonRes {
    private String lessonName;
    private String chapterName;
    private String courseName;
    private String description;
    private String type;
    private String url;
    private int order;
    private String status;
    private String createdDate;
    private String updatedDate;
    private String sort;
    private int page;
    private int size;
}
