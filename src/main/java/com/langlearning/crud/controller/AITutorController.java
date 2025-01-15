package com.langlearning.crud.controller;

import com.langlearning.crud.entity.ai.AITutor;
import com.langlearning.crud.service.AITutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ai-tutor")
public class AITutorController {
    @Autowired
    private AITutorService aITutorService;

    @GetMapping("/all")
    public ResponseEntity<List<AITutor>> getAllAITutors() {
        return aITutorService.getAllAITutors();
    }

    @PostMapping("/create")
    public ResponseEntity<AITutor> createEntity(@RequestBody AITutor entity) {
        return aITutorService.createEntity(entity);
    }

    @PostMapping("/update")
    public ResponseEntity<AITutor> updateEntity(@RequestBody AITutor entity) {
        return aITutorService.updateEntity(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable int id) {
        return aITutorService.deleteEntity(id);

    }
}
