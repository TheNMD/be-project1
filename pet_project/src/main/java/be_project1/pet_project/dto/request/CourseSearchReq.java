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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Accessors(chain=true)
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)

public class CourseSearchReq {
    private String courseName;
    private String teacherName;
    private String status;
    private double rating;
    private String createdDate;
}