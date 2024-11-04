package be_project1.pet_project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import be_project1.pet_project.entity.CourseEntity;

@Repository("courseRepos")
public interface CourseRepos extends JpaRepository<CourseEntity, Integer> {

}
