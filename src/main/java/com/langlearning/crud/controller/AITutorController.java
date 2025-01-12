package com.langlearning.crud.controller;

import com.langlearning.crud.entity.ai.AITutor;
import com.langlearning.crud.service.AITutorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai-tutor")
public class AITutorController {
    @Autowired
    private AITutorService aITutorService;


    @GetMapping("/all")
    public List<AITutor> getAllAITutors() {
        return aITutorService.getAllAITutors();
    }
}
