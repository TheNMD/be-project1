package be_project1.pet_project.entity;

import java.util.List;
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
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity(name = "courseEntity")
@Table(name = "courseEntity")
public class CourseEntity {
    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // PK to ChapterEntity
    @OneToMany(mappedBy = "courseObj", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<ChapterEntity> chapterList;

    // PK to UserCourseEntity
    @OneToMany(mappedBy = "courseObj", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<UserCourseEntity> ucList;

    // FK from TeacherEntity
    @ManyToOne
    @JoinColumn(name = "teacherId")
    private TeacherEntity teacherObj;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;
}
