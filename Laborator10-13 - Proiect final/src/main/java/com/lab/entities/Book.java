package com.lab.entities;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import  com.lab.services.*;
@Entity
@Table(name = "Book")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book implements Visitee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    @NotNull
    private String title;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinTable(name = "books_authors", joinColumns = @JoinColumn(name = "id_book"), inverseJoinColumns = @JoinColumn(name = "id_author"))
    private List<Author> authors;

    private ArrayList<Element> elements;

    public Book(String title) {
        this.title = title;
        this.authors = new ArrayList<Author>();

    }
    public void addAuthor (Author author) {
        this.authors.add((author));
    }

    public void addContent (Element element) {
        this.elements.add( element );
    }

    public String getTitle()
    {
        return this.title;
    }


    public ArrayList<Element> getElements()
    {
        return this.elements;
    }

    public List<Author> getAuthors()
    {
        return this.authors;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.VisitBook(this);
    }

}