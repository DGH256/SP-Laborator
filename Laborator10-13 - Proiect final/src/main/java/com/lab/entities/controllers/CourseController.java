package com.lab.entities.controllers;

import com.lab.entities.Book;
import com.lab.entities.Course;
import com.lab.entities.Student;
import com.lab.entities.Teacher;
import com.lab.services.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service= service;
    }

    @PostMapping("/save")
    public ResponseEntity<Course> saveCourse(@RequestBody Course item) {
        return new ResponseEntity<>(service.saveItem(item), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Course> getAll() {
        return service.getAll();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}/getStudents/")
    public List<Student> getStudents(@PathVariable Long id){

        Course item = service.getItem(id);

        return item.getStudents();
    }

    @GetMapping("/{id}/getTeachers/")
    public List<Teacher> getTeachers(@PathVariable Long id){

        Course item = service.getItem(id);

        return item.getTeachers();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getItem(id), HttpStatus.OK);
    }

}
