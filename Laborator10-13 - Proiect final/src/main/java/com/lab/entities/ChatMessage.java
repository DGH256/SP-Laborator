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
@Table(name = "ChatMessage")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ChatMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "content")
    @NotNull
    private String content;

    @Column(name = "sender")
    private String sender;

    public ChatMessage(String content)
    {
        this.content=content;
    }

    public ChatMessage(String sender, String content)
    {
        this.sender=sender;
        this.content=content;
    }
}
