package com.lab.entities.controllers;

import com.lab.entities.Book;
import com.lab.entities.Student;
import com.lab.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service= service;
    }

    @PostMapping("/save")
    public ResponseEntity<Book> saveBook(@RequestBody Book item) {
        return new ResponseEntity<>(service.saveItem(item), HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<Book> getAll() {
        return service.getAll();
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getItem(id), HttpStatus.OK);
    }

}
