package com.cpan228.learnsphere.repository;

import com.cpan228.learnsphere.model.Course;
import com.cpan228.learnsphere.model.CourseCategory;
import com.cpan228.learnsphere.model.DifficultyLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(exported = false)
public interface CourseRepository extends JpaRepository<Course, Long> {

    boolean existsByCourseCodeIgnoreCase(String courseCode);

    @Query("""
            SELECT c FROM Course c
            WHERE (
                :keyword = ''
                OR LOWER(c.title) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(c.courseCode) LIKE LOWER(CONCAT('%', :keyword, '%'))
                OR LOWER(c.instructorName) LIKE LOWER(CONCAT('%', :keyword, '%'))
            )
            AND (:category IS NULL OR c.category = :category)
            AND (:difficulty IS NULL OR c.difficulty = :difficulty)
            """)
    Page<Course> searchCourses(
            @Param("keyword") String keyword,
            @Param("category") CourseCategory category,
            @Param("difficulty") DifficultyLevel difficulty,
            Pageable pageable
    );
}