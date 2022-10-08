package com.example.demo.services;

import com.example.demo.Dto.StageDto;
import com.example.demo.entities.Stage;
import com.example.demo.repository.StageRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IStageService implements StageService {

    @Autowired
    StageRepository stageRepository;

    @Autowired
    ModelMapper mapper;

    public List<StageDto> getAllStages() {
        List<com.example.demo.entities.Stage> entities = stageRepository.findAll();
        List<StageDto> stageDtos = new ArrayList<>();

        for (Stage entity : entities) {
            StageDto chatDto = mapper.map(entity, StageDto.class);
            stageDtos.add(chatDto);
        }

        return stageDtos;
    }

    public StageDto addStage(StageDto stageDto){
        Stage stage = mapper.map(stageDto, Stage.class);
        stage = stageRepository.save(stage);
        StageDto result = mapper.map(stage, StageDto.class);
        return result;
    }

}
