package be_project1.pet_project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import be_project1.pet_project.entity.UserCourseEntity;
import be_project1.pet_project.entity.key.UserCourseKey;

@Repository("userCourseRepos")
public interface UserCourseRepos extends JpaRepository<UserCourseEntity, UserCourseKey> {

}
