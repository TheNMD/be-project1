package be_project1.pet_project.dto.request;

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

import be_project1.pet_project.constant.RegexConst;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain=true)
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class LessonCreateReq {
    @NotNull(message = "Lesson Name cannot be null")
    @Size(min = 1, max = 20, message = "Lesson Name must be between 1 and 20 characters long")
    private String lessonName;

    @NotNull(message = "Chapter Name cannot be null")
    @Size(min = 1, max = 20, message = "Chapter Name must be between 1 and 20 characters long")
    private String chapterName;

    @NotNull(message = "Course Name cannot be null")
    @Size(min = 1, max = 20, message = "Course Name must be between 1 and 20 characters long")
    private String courseName;

    @Size(min = 0, max = 200, message = "Description must be less than 200 characters long")
    private String description;

    @NotNull(message = "Type cannot be null")
    @Pattern(regexp = RegexConst.TYPE, message = "Type must be either 'video' or 'docx' or 'pdf' or 'slide'")
    private String type;

    @Pattern(regexp = RegexConst.URL, message = "Status must be either 'active' or 'inactive'")
    private String url;

    @NotNull(message = "Order cannot be null")
    @Positive(message = "Order must be greater than zero")
    private int order;

    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @Pattern(regexp = RegexConst.DATETIME, message = "Timestamp must be yyyy-mm-dd hh:mm:ss")
    private String createdDate;
}
