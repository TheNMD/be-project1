package be_project1.pet_project.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import be_project1.pet_project.entity.ChapterEntity;

@Repository("chapterRepos")
public interface ChapterRepos extends JpaRepository<ChapterEntity, Integer> {

}
