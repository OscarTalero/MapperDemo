package com.example.demo.controllers;

import com.example.demo.Dto.ChatDto;
import com.example.demo.Dto.StageDto;
import com.example.demo.services.StageService;
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
@RequestMapping("/stages")
public class StageController {

    @Autowired
    private StageService stageService;

    @GetMapping
    public ResponseEntity<List<StageDto>> getAllStages() {
        List<StageDto> stagesDto = stageService.getAllStages();
        return ResponseEntity.ok().body(stagesDto);
    }

    @PostMapping()
    public ResponseEntity<StageDto> addStage(@RequestBody StageDto newstage) {
        StageDto stageSaved = stageService.addStage(newstage);
        return ResponseEntity.status(HttpStatus.CREATED).body(stageSaved);
    }
}
