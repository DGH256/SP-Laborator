package com.lab.services;

import com.lab.entities.Course;
import com.lab.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import com.lab.entities.Student;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class StudentService {
    private final StudentRepository repository;

    public StudentService(StudentRepository repository)
    {
        this.repository=repository;
    }

    public Student saveItem(Student student)
    {
        return repository.save(student);
    }

    public Student getItem(Long id)
    {
        Optional<Student> optStudent = repository.findById(id);

        if(optStudent.isPresent())
        {
        return optStudent.get();
        }

        return null; //throw new exception
    }

    public void deleteItem(Long id)
    {
        repository.deleteById(id);
    }

    public List<Student> getAll()
    {
        List<Student> allItems = repository.findAll();

        return allItems;
    }
}
