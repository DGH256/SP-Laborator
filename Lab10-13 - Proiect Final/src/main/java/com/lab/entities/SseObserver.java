package com.lab.entities;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

public class SseObserver {

    SseEmitter emitter =null;

    public SseObserver(SseEmitter emitter)
    {
        this.emitter=emitter;
    }
    public void update(Book book)
    {
        try {
            emitter.send(book);
        }
        catch (Exception ex){}

    }
}
