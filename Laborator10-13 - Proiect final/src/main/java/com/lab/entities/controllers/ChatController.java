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
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/chat")
public class ChatController {

    private final ChatMessageService service;

    public ChatController(ChatMessageService service) {
        this.service= service;
    }

    @PostMapping("/save")
    public ResponseEntity<ChatMessage> saveItem(@RequestBody ChatMessage item) {
        service.saveItem(item);

        try {
            chatEmitter.send(item, MediaType.APPLICATION_JSON);
        }
        catch (IOException ex) {}

        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public List<ChatMessage> getAll() {
        return service.getAll();
    }

    SseEmitter chatEmitter;

    @GetMapping("/sse_getAll")
    public ResponseBodyEmitter sse_getAll()
    {
        //Keeping the SSeEmitter open forever
        chatEmitter = new SseEmitter(18000000L);

        List<ChatMessage> allMessages = service.getAll();

        int maxMessagesReturned = 10;

        allMessages=allMessages.subList(allMessages.size()-maxMessagesReturned, allMessages.size());

        try {
            chatEmitter.send(allMessages, MediaType.APPLICATION_JSON);
        }
        catch (IOException ex) {}

        return chatEmitter;
    }

    @GetMapping("sse_saveMessage")
    public void sse_saveMessage()
    {
        ChatMessage newMessage = new ChatMessage("sender1"," content 1");
        service.saveItem(newMessage);

        try {
            chatEmitter.send(newMessage, MediaType.APPLICATION_JSON);
        }
        catch (IOException ex) {}

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

}
