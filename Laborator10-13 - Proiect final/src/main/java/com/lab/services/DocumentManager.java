package com.lab.services;

import com.lab.entities.*;

public class DocumentManager {
    private Book book;

    private static DocumentManager instance;

    private DocumentManager()
    {
    }

    public static DocumentManager getInstance()
    {
        if(instance==null)
        {
            instance=new DocumentManager();
        }

        return instance;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book=book;
    }


}
