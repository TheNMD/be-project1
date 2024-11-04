package be_project1.pet_project.entity;

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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity(name = "lessonEntity")
@Table(name = "lessonEntity")
public class LessonEntity {
    // PK
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // PK to UserCourseLessonEntity
    @OneToMany(mappedBy = "lessonObj", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    private List<UserCourseLessonEntity> uclList;

    // FK from ChapterEntity
    @ManyToOne
    @JoinColumn(name = "chapterId")
    private ChapterEntity chapterObj;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "url")
    private String url;

    @Column(name = "lessonOrder")
    private int lessonOrder;

    @Column(name = "status")
    private String status;

    @Column(name = "createdDate")
    private Date createdDate;

    @Column(name = "updatedDate")
    private Date updatedDate;
}
