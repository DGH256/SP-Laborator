package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Book extends Element{

    private ArrayList<Author> authors = new ArrayList<>();

    public Book(String title) {
        this.setTitle(title);
    }

    public void addContent(Element element)
    {
        this.add(element);
    }

    public void addAuthor(Author author)
    {
        this.authors.add(author);
    }

    public void print()
    {
        super.print();

    }

    //This is where we "overload" the print function and add the author names;
    public String printExtraInfo()
    {
        String displayString = " and Authors: ";

        for(int i=0;i<authors.size();i++)
        {
            displayString+=authors.get(i).getName();

            if(i< authors.size()-1)
            {
                displayString+=", ";
            }
        }

        return displayString;
    }



}
