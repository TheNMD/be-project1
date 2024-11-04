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
public class UserCourseKey implements Serializable {
    private int userID;

    private int courseID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserCourseKey)) return false;
        UserCourseKey that = (UserCourseKey) o;
        return userID == that.userID && courseID == that.courseID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userID, courseID);
    }
}