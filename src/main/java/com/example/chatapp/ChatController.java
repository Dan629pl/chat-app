package com.example.chatapp;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController
public class ChatController {

    private ChatStore chatStore;

    public ChatController(ChatStore chatStore) {
        this.chatStore = chatStore;
    }

    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
        chatStore.storeMessage(chatMessage);
        return chatMessage;
    }

    @GetMapping("/chat-history")
    public List<ChatMessage> getHistory() {
        return chatStore.getHistory();
    }

}
