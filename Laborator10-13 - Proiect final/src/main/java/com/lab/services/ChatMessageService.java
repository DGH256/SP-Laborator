package com.lab.services;

import com.lab.entities.ChatMessage;
import com.lab.repositories.ChatMessageRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ChatMessageService {
    private final ChatMessageRepository repository;

    public ChatMessageService(ChatMessageRepository repository)
    {
        this.repository=repository;
    }

    public ChatMessage saveItem(ChatMessage item)
    {
        return repository.save(item);
    }

    public ChatMessage getItem(Long id)
    {
        Optional<ChatMessage> optItem = repository.findById(id);

        if(optItem.isPresent())
        {
            return optItem.get();
        }

        return null;
    }

    public void deleteItem(Long id)
    {
        repository.deleteById(id);
    }

    public List<ChatMessage> getAll()
    {
        List<ChatMessage> allItems = repository.findAll();

        return allItems;
    }
}
