package be_project1.pet_project.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.BindParam;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class CourseSearchReq {

    private Integer userId;

    private String name;

    private String createdDateFrom; // yyyy-MM-dd HH:mi:ss

    private String createdDateTo; // yyyy-MM-dd HH:mi:ss

    private String teacherName;

    private Float ratingFrom; // >= 0

    private Float ratingTo; // <= 10

    private String status; // ACTIVE || INACTIVE

    private Integer numberOfLessonFrom; // >= 1

    private Integer numberOfLessonTo; // >= 1

    private Integer pageIndex; // >= 0

    private Integer pageSize; // <= 1

    private List<CourseSort> sort;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class CourseSort {

        public static final String ASC = "asc";

        public static final String DESC = "desc";

        private String field;

        private String order;
    }
}
