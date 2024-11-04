package be_project1.pet_project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import be_project1.pet_project.entity.User;

@Repository("userRepos")
public interface UserRepos extends JpaRepository<User, Integer> {

}
