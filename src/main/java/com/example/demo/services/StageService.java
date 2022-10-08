package com.example.demo.services;

import com.example.demo.Dto.StageDto;

import java.util.List;

public interface StageService {

    StageDto addStage(StageDto dto);
    List<StageDto> getAllStages();
}
