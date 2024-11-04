package be_project1.pet_project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import be_project1.pet_project.entity.TeacherEntity;

@Repository("teacherRepos")
public interface TeacherRepos extends JpaRepository<TeacherEntity, Integer> {
    Optional<TeacherEntity> findByUsername(String username);
}
