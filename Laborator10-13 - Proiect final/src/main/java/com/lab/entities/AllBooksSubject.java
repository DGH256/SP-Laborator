package com.lab.entities;

import java.util.ArrayList;
import java.util.List;

public class AllBooksSubject {

    private final List<SseObserver> observers = new ArrayList<>();
    private Book book;

    public void attach(SseObserver o) {
        observers.add(o);
    }

    public void detach(SseObserver o) {
        observers.remove(o);
    }

    public void addBook(Book book)
    {
        this.book=book;
    }

    public void notifyUpdate(String message) {
        for(SseObserver o: observers) {
            o.update(book);
        }
    }

}
