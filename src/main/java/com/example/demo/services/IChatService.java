package com.example.demo.services;

import com.example.demo.Dto.ChatDto;
import com.example.demo.entities.Chat;
import com.example.demo.repository.ChatRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IChatService implements ChatService {

    @Autowired
    ChatRepository chatRepository;

    //Se inyecta el Bean creado en funcion principal
    @Autowired
    ModelMapper mapper;

    public List<ChatDto> getAllChats() {
        List<Chat> entities = chatRepository.findAll();
        List<ChatDto> chatDtos = new ArrayList<>();

        for (Chat entity : entities) {
            ChatDto chatDto = mapper.map(entity, ChatDto.class);
            chatDtos.add(chatDto);
        }

        return chatDtos;
    }

    public ChatDto addChat(ChatDto chatDto){
        //Se utiliza el mapper pasandole dos parametros(objeto incial, objeto destino)
        Chat chat = mapper.map(chatDto, Chat.class);
        chat = chatRepository.save(chat);
        ChatDto result = mapper.map(chat, ChatDto.class);
        return result;
    }

}
