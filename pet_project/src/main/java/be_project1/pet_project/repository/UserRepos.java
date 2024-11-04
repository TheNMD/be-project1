package be_project1.pet_project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import be_project1.pet_project.entity.UserEntity;

@Repository("userRepos")
public interface UserRepos extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
}
