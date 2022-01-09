package com.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
