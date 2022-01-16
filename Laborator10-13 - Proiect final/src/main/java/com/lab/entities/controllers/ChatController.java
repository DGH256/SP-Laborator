package com.lab.entities.controllers;

import com.lab.entities.Book;
import com.lab.entities.ChatMessage;
import com.lab.entities.Student;
import com.lab.services.BookService;
import com.lab.services.ChatMessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatMessageService service;
    private final int maxMessagesReturned = 10;
    ArrayList<SseEmitter> emitterList = new ArrayList<>() ;

    public ChatController(ChatMessageService service) {
        this.service= service;
    }

    @PostMapping("/save")
    public ResponseEntity<ChatMessage> saveItem(@RequestBody ChatMessage item) {
        service.saveItem(item);

        broadcastToEmitters(item);

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<ChatMessage> getAll() {
        return service.getAll();
    }


    @GetMapping("/sse_getAll")
    public ResponseBodyEmitter sse_getAll()
    {
        //Keeping the SSeEmitter open forever
        SseEmitter chatEmitter = new SseEmitter(18000000L);

        emitterList.add(chatEmitter);

        List<ChatMessage> allMessages = service.getAll();

        allMessages=allMessages.subList(allMessages.size()-maxMessagesReturned, allMessages.size());

        broadcastToEmitter(allMessages, chatEmitter);

        return chatEmitter;
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteItem(@PathVariable Long id) {
        service.deleteItem(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ChatMessage> getItemById(@PathVariable Long id) {
        return new ResponseEntity<>(service.getItem(id), HttpStatus.OK);
    }


    private void broadcastToEmitters(ChatMessage item)
    {
        for(SseEmitter e:emitterList)
        {
            try {
                e.send(item, MediaType.APPLICATION_JSON);
            }
            catch (IOException ex) {}
        }
    }

    private void broadcastToEmitters(Iterable<ChatMessage> messages)
    {
        for(ChatMessage message : messages)
        {
            broadcastToEmitters(message);
        }
    }

    private void broadcastToEmitter(ChatMessage item, SseEmitter emitter)
    {
        try {
            emitter.send(item, MediaType.APPLICATION_JSON);
        }
        catch (IOException ex) {}
    }

    private void broadcastToEmitter(Iterable<ChatMessage> messages, SseEmitter emitter)
    {
        for(ChatMessage message : messages)
        {
            broadcastToEmitter(message,emitter);
        }
    }


}
