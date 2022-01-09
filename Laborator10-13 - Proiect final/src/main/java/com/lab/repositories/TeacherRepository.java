package com.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.lab.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
