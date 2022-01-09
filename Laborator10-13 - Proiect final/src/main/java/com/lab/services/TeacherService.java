package com.lab.services;

import com.lab.entities.Student;
import com.lab.entities.Teacher;
import com.lab.repositories.TeacherRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TeacherService {
    private final TeacherRepository repository;

    public TeacherService(TeacherRepository repository)
    {
        this.repository=repository;
    }

    public Teacher saveItem(Teacher teacher)
    {
        return repository.save(teacher);
    }

    public Teacher getItem(Long id)
    {
        Optional<Teacher> optItem = repository.findById(id);

        if(optItem.isPresent())
        {
            return optItem.get();
        }

        return null;
    }

    public List<Teacher> getAll()
    {
        List<Teacher> allItems = repository.findAll();

        return allItems;
    }

    public void deleteItem(Long id)
    {

        repository.deleteById(id);
    }
}
