package be_project1.pet_project.dto.request;

import java.util.Date;

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
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.FutureOrPresent;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain=true)
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class CourseUpdateReq {
    @Size(min = 1, max = 20, message = "Course Name must be between 1 and 20 characters long")
    private String name;

    @Size(min = 0, max = 200, message = "Description must be less than 200 characters long")
    private String description;

    @Pattern(regexp = RegexConst.STATUS, message = "Status must be either 'active' or 'inactive'")
    private String status;

    @FutureOrPresent
    private Date createdDate;

    @FutureOrPresent
    private Date updatedDate;

    @Positive(message = "teacherId must be greater than zero")
    private int teacherId;
}
