package com.lab.services;

import com.lab.entities.Book;
import com.lab.entities.Course;
import com.lab.repositories.CourseRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CourseService {
    private final CourseRepository repository;

    public CourseService(CourseRepository repository)
    {
        this.repository=repository;
    }

    public Course saveItem(Course course)
    {
        return repository.save(course);
    }

    public Course getItem(Long id)
    {
        Optional<Course> optItem = repository.findById(id);

        if(optItem.isPresent())
        {
            return optItem.get();
        }

        return null;
    }

    public void deleteItem(Long id)
    {
        repository.deleteById(id);
    }

    public List<Course> getAll()
    {
        List<Course> allItems = repository.findAll();

        return allItems;
    }
}
