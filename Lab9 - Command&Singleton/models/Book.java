package models;

import services.*;

import java.util.ArrayList;

public class Book implements Visitee {
    private String title;
    private ArrayList<Element> elements;
    private ArrayList<Author> authors;

    public Book(String title) {
        this.title = title;
        this.elements = new ArrayList<Element>();
        this.authors = new ArrayList<Author>();
    }

    public void addContent (Element element) {
        this.elements.add( element );
    }

    public void addAuthor (Author author) {
        this.authors.add((author));
    }

    public String getTitle()
    {
        return this.title;
    }

    public ArrayList<Element> getElements()
    {
        return this.elements;
    }

    public ArrayList<Author> getAuthors()
    {
        return this.authors;
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.VisitBook(this);
    }

}