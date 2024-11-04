package be_project1.pet_project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import be_project1.pet_project.entity.AdminEntity;

@Repository("adminRepos")
public interface AdminRepos extends JpaRepository<AdminEntity, Integer> {
    Optional<AdminEntity> findByUsername(String username);
}
