package be_project1.pet_project.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import be_project1.pet_project.entity.key.UserCourseKey;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity(name = "userCourseEntity")
@Table(name = "userCourseEntity")
@IdClass(UserCourseKey.class)
public class UserCourseEntity implements Serializable {
    // PK
    @Id
    @Column(name = "userId")
    private int userId;

    // FK from UserEntity
    @ManyToOne
    @JoinColumn(name = "userId", nullable = false,  insertable = false, updatable = false)
    private UserEntity userObj;
    
    // PK
    @Id
    @Column(name = "courseId")
    private int courseId;

    // FK from CourseEntity
    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false,  insertable = false, updatable = false)
    private CourseEntity courseObj;

    // Composite PKs to UserCourseLessonEntity
    @OneToMany(mappedBy = "ucObj", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<UserCourseLessonEntity> uclList;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "review")
    private String review;

    @Column(name = "status")
    private String status;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;
}
