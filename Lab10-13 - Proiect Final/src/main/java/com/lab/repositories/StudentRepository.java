package com.lab.repositories;

import com.lab.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameAndLastName(String firsName, String lastName);
    @Query("FROM Student where age=:varsta")
    List<Student> findByAge(@Param("varsta") int varsta);
}
