package com.lab.entities.controllers;

import com.lab.entities.Course;
import com.lab.entities.Student;
import com.lab.entities.Teacher;
import com.lab.services.CourseService;
import com.lab.services.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService service;
    private final CourseService service_course;

    public TeacherController(TeacherService service, CourseService service_course) {
        this.service= service;
        this.service_course = service_course;
    }

    @PostMapping("/save")
    public ResponseEntity<Teacher> saveItem(@RequestBody Teacher item) {
        return new ResponseEntity<>(service.saveItem(item), HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}/getCourses/")
    public List<Course> getCourses(@PathVariable Long id){

        Teacher item = service.getItem(id);

        return item.getCourses();
    }

    @GetMapping("/getAll")
    public List<Teacher> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getItem(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/addCourse/{id_course}")
    public ResponseEntity<Teacher> addCourse(@PathVariable Long id, @PathVariable Long id_course) {

        Course course = service_course.getItem(id_course);
        Teacher teacher = service.getItem(id);

        if(teacher !=null && course !=null)
        {
            teacher.addCourse(course);
        }

        service.saveItem(teacher);

        return new ResponseEntity<>(teacher, HttpStatus.OK);
    }

}
