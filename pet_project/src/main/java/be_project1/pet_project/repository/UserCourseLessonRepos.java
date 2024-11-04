package be_project1.pet_project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import be_project1.pet_project.entity.UserCourseLessonEntity;
import be_project1.pet_project.entity.key.UserCourseLessonKey;

@Repository("userCourseLessonRepos")
public interface UserCourseLessonRepos extends JpaRepository<UserCourseLessonEntity, UserCourseLessonKey> {

}
