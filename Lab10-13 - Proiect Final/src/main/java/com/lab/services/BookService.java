package com.lab.services;

import com.lab.entities.Book;
import com.lab.repositories.BookRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository)
    {
        this.repository=repository;
    }

    public Book saveItem(Book item)
    {
        return repository.save(item);
    }

    public Book getItem(Long id)
    {
        Optional<Book> optItem = repository.findById(id);

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

    public List<Book> getAll()
    {
        List<Book> allItems = repository.findAll();

        return allItems;
    }
}
