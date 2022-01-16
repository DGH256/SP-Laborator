package com.lab.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "course")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private int credits;
    private int year;


    @PreRemove
    public void removeTrick()
    {
        // Using this so the students&teachers associated to this course
        // DON'T get deleted when we delete the course
        this.students.clear();
        this.teachers.clear();
    }

    //@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @ManyToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "student_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "student_id"))
    //@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@student_id")
    //@JsonBackReference
    //@JsonIgnore
    private List<Student> students;

    //@ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    //@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @ManyToMany(cascade = {CascadeType.REMOVE}, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    @JoinTable(name = "teacher_course", joinColumns = @JoinColumn(name = "course_id"), inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    //@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@teacher_id")
    //@JsonBackReference
    //@JsonIgnore
    private List<Teacher> teachers;

    public void addStudent(Student student) {
        if (students == null) {
            students = new ArrayList<>();
        }
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        if (teachers == null) {
            teachers = new ArrayList<>();
        }
        teachers.add(teacher);
    }
}
