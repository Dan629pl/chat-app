package com.example.chatapp;

import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ChatStore {

    private LinkedList<ChatMessage> history = new LinkedList<>();

    public void storeMessage(ChatMessage chatMessage) {
        history.addLast(chatMessage);
    }

    public List<ChatMessage> getHistory() {
        return history;
    }
}
