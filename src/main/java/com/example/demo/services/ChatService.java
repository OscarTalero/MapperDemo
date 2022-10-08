package com.example.demo.services;

import com.example.demo.Dto.ChatDto;

import java.util.List;

public interface ChatService {

    ChatDto addChat(ChatDto dto);
    List<ChatDto> getAllChats();
}
