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
import jakarta.persistence.Column;

import be_project1.pet_project.entity.key.UserCourseKey;

@NoArgsConstructor
@AllArgsConstructor
@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Entity(name="UserCourseEnity")
@Table(name="UserCourseEnity")
@IdClass(UserCourseKey.class)
public class UserCourseEntity implements Serializable {
    @Id
    private int userId;

    @Id
    private int courseId;

    @Column(name="rating")
    private double rating;

    @Column(name="review")
    private String review;

    @Column(name="status")
    private String status;

    @Column(name="createdDate")
    private Date createdDate;

    @Column(name="updatedDate")
    private Date updatedDate;
}
