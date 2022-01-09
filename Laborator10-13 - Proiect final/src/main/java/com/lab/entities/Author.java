package com.lab.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Author")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotNull
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "books_authors", joinColumns = @JoinColumn(name = "id_author"), inverseJoinColumns = @JoinColumn(name = "id_book"))
    private List<Book> books;

    public void addBook(Book book)
    {
        if(books==null){books=new ArrayList<>();}

        books.add(book);
    }
    public Author(String name) {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void print() {
        System.out.println(this.name);
    }
}
