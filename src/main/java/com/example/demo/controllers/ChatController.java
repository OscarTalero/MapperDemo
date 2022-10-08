package com.example.demo.controllers;

import com.example.demo.Dto.ChatDto;
import com.example.demo.entities.Chat;
import com.example.demo.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping
    public ResponseEntity<List<ChatDto>> getAllChats() {
        List<ChatDto> chatsDto = chatService.getAllChats();
        return ResponseEntity.ok().body(chatsDto);
    }

    @PostMapping()
    public ResponseEntity<ChatDto> addChat(@RequestBody ChatDto newchat) {
        ChatDto chatSaved = chatService.addChat(newchat);
        return ResponseEntity.status(HttpStatus.CREATED).body(chatSaved);
    }
}
