package be_project1.pet_project.repository;

import be_project1.pet_project.entity.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

    @Query(value = "SELECT c.*, " +
            "       (SELECT COUNT(*) " +
            "        FROM lesson l " +
            "        WHERE l.chapter_id IN (SELECT ch.id " +
            "                               FROM chapter ch " +
            "                               WHERE ch.course_id = c.id)) AS 'number_of_lesson', " +
            "       (SELECT AVG(uc.rating) FROM user_course uc WHERE uc.course_id = c.id) AS rate " +
            "FROM course c " +
            "         INNER JOIN teacher t ON t.id = c.teacher_id " +
            "         INNER JOIN user_course uc ON uc.course_id = c.id " +
            "WHERE (:name IS NULL OR LOWER(c.name) LIKE CONCAT('%', LOWER(:name), '%')) " +
            "  AND (:createdDateFrom IS NULL OR c.created_date >= :createdDateFrom) " +
            "  AND (:createdDateTo IS NULL OR c.created_date <= :createdDateTo) " +
            "  AND (:status IS NULL OR c.status = :status) " +
            "  AND (:userId IS NULL OR uc.user_id = :userId) " +
            "  AND (:numberOfLessonFrom IS NULL OR " +
            "       (SELECT COUNT(*) " +
            "        FROM lesson l " +
            "        WHERE l.chapter_id IN (SELECT ch.id " +
            "                               FROM chapter ch " +
            "                               WHERE ch.course_id = c.id)) >= :numberOfLessonFrom) " +
            "  AND (:numberOfLessonTo IS NULL OR " +
            "       (SELECT COUNT(*) " +
            "        FROM lesson l " +
            "        WHERE l.chapter_id IN (SELECT ch.id " +
            "                               FROM chapter ch " +
            "                               WHERE ch.course_id = c.id)) <= :numberOfLessonTo) " +
            "  AND (:ratingFrom IS NULL OR " +
            "       (SELECT AVG(uc.rating) FROM user_course uc WHERE uc.course_id = c.id) >= :ratingFrom) " +
            "  AND (:ratingTo IS NULL OR " +
            "       (SELECT AVG(uc.rating) FROM user_course uc WHERE uc.course_id = c.id) <= :ratingTo) ",
            nativeQuery = true
    )
    List<Course> searchCourse(
        @Param("name") String name,
        @Param("createdDateFrom") String createdDateFrom,
        @Param("createdDateTo") String createdDateTo,
        @Param("status") String status,
        @Param("userId") Integer userId,
        @Param("numberOfLessonFrom") Integer numberOfLessonFrom,
        @Param("numberOfLessonTo") Integer numberOfLessonTo,
        @Param("ratingFrom") Float ratingFrom,
        @Param("ratingTo") Float ratingTo,
        Pageable pageable
    );

    @Query(value = "SELECT count(1)" +
        " FROM course c " +
        "         INNER JOIN teacher t ON t.id = c.teacher_id " +
        "         INNER JOIN user_course uc ON uc.course_id = c.id " +
        "WHERE (:name IS NULL OR LOWER(c.name) LIKE CONCAT('%', LOWER(:name), '%')) " +
        "  AND (:createdDateFrom IS NULL OR c.created_date >= :createdDateFrom) " +
        "  AND (:createdDateTo IS NULL OR c.created_date <= :createdDateTo) " +
        "  AND (:status IS NULL OR c.status = :status) " +
        "  AND (:userId IS NULL OR uc.user_id = :userId) " +
        "  AND (:numberOfLessonFrom IS NULL OR " +
        "       (SELECT COUNT(*) " +
        "        FROM lesson l " +
        "        WHERE l.chapter_id IN (SELECT ch.id " +
        "                               FROM chapter ch " +
        "                               WHERE ch.course_id = c.id)) >= :numberOfLessonFrom) " +
        "  AND (:numberOfLessonTo IS NULL OR " +
        "       (SELECT COUNT(*) " +
        "        FROM lesson l " +
        "        WHERE l.chapter_id IN (SELECT ch.id " +
        "                               FROM chapter ch " +
        "                               WHERE ch.course_id = c.id)) <= :numberOfLessonTo) " +
        "  AND (:ratingFrom IS NULL OR " +
        "       (SELECT AVG(uc.rating) FROM user_course uc WHERE uc.course_id = c.id) >= :ratingFrom) " +
        "  AND (:ratingTo IS NULL OR " +
        "       (SELECT AVG(uc.rating) FROM user_course uc WHERE uc.course_id = c.id) <= :ratingTo) ",
        nativeQuery = true
    )
    Long countItemSearchCourse(
        @Param("name") String name,
        @Param("createdDateFrom") String createdDateFrom,
        @Param("createdDateTo") String createdDateTo,
        @Param("status") String status,
        @Param("userId") Integer userId,
        @Param("numberOfLessonFrom") Integer numberOfLessonFrom,
        @Param("numberOfLessonTo") Integer numberOfLessonTo,
        @Param("ratingFrom") Float ratingFrom,
        @Param("ratingTo") Float ratingTo
    );
}