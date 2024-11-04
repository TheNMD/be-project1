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
@Entity(name = "chapterEntity")
@Table(name = "chapterEntity")
public class ChapterEntity {
    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // PK to LessonEntity
    @OneToMany(mappedBy = "chapterObj", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<LessonEntity> lessonList;

    // FK from CourseEntity
    @ManyToOne
    @JoinColumn(name = "courseId", nullable = false)
    private CourseEntity courseObj;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "chapterOrder")
    private int chapterOrder;

    @Column(name = "status")
    private String status;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;
}
