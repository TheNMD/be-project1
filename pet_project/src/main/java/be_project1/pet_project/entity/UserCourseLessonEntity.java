package be_project1.pet_project.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

import be_project1.pet_project.entity.key.UserCourseLessonKey;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity(name = "userCourseLessonEntity")
@Table(name = "userCourseLessonEntity")
@IdClass(UserCourseLessonKey.class)
public class UserCourseLessonEntity implements Serializable {
    // PK
    @Id
    @Column(name = "ucUserId")
    private int ucUserId;

    // PK
    @Id
    @Column(name = "ucCourseId")
    private int ucCourseId;

    // Compsite FKs from UserCourseEntity
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "ucUserId", referencedColumnName = "userId", insertable = false, updatable = false),
        @JoinColumn(name = "ucCourseId", referencedColumnName = "courseId", insertable = false, updatable = false)
    })
    private UserCourseEntity ucObj;

    // PK
    @Id
    @Column(name = "lessonId")
    private int lessonId;

    // FK from LessonEntity
    @ManyToOne
    @JoinColumn(name = "lessonId", nullable = false,  insertable = false, updatable = false)
    private LessonEntity lessonObj;

    @Column(name = "status")
    private String status;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;
}
