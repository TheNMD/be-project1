package be_project1.pet_project.entity.key;

import java.io.Serializable;
import java.util.Objects;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserCourseLessonKey implements Serializable {
    private int ucUserId;

    private int ucCourseId;

    private int lessonId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCourseLessonKey)) return false;
        UserCourseLessonKey that = (UserCourseLessonKey) o;
        // Compare the fields
        return ucUserId == that.ucUserId &&
               ucCourseId == that.ucCourseId &&
               lessonId == that.lessonId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ucUserId, ucCourseId, lessonId);
    }
}