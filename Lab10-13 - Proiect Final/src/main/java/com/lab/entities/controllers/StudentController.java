package com.lab.entities.controllers;

import com.lab.entities.Course;
import com.lab.entities.Student;
import com.lab.entities.Teacher;
import com.lab.services.CourseService;
import com.lab.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService service;
    private final CourseService service_course;

    public StudentController(StudentService service, CourseService service_course) {
        this.service= service;
        this.service_course = service_course;
    }

    @PostMapping("/save")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(service.saveItem(student), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Student> getAll() {
        return service.getAll();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}/addCourse/{id_course}")
    public ResponseEntity<Student> addCourse(@PathVariable Long id, @PathVariable Long id_course) {

        Course course = service_course.getItem(id_course);
        Student student = service.getItem(id);

        if(student !=null && course !=null)
        {
            student.addCourse(course);
        }
        else
        {
            return new ResponseEntity("Invalid request", HttpStatus.OK);
        }

        service.saveItem(student);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/{id}/getCourses/")
    public List<Course> getCourses(@PathVariable Long id){

        Student student = service.getItem(id);

        return student.getCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getItem(id), HttpStatus.OK);
    }

}
