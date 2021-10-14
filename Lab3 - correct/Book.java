package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
public class Book {
    private String title;
    private ArrayList<Element> elements;
    private ArrayList<Author> authors;

    public Book(String title) {
        this.title = title;
        this.elements = new ArrayList<Element>();
        this.authors = new ArrayList<Author>();
    }

    public void addContent (Element element) {
        this.elements.add(element.clone());
    }

    public void addAuthor (Author author) {
        this.authors.add((author));
    }

    public void print() {
        System.out.println("Carte: " + this.title);

        System.out.println("Autori: ");
        for (Author i : this.authors)
            i.print();

        System.out.println("Elemente: ");
        for (Element i : this.elements)
            i.print();

        System.out.println();
    }
}