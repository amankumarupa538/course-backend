package com.pragyan.repository;

import com.pragyan.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByInstructorId(Long instructorId);

    @Query("SELECT count(c) from Course c")
    public long courseCount();
}
