package com.langlearning.crud.controller;

import com.langlearning.crud.entity.assessment.SpeakingAssessment;
import com.langlearning.crud.service.SpeakingAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/speaking-assessment")
public class SpeakingAssessmentController {
    @Autowired
    private SpeakingAssessmentService speakingAssessmentService;

    @GetMapping("/all")
    public ResponseEntity<List<SpeakingAssessment>> getAllSpeakingAssessments() {
        return speakingAssessmentService.getAllSpeakingAssessments();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpeakingAssessment> getEntityById(@PathVariable int id) {
        return speakingAssessmentService.getSpeakingAssessmentById(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<SpeakingAssessment>> getFeedbackByUserId(@PathVariable int userId) {
        return speakingAssessmentService.getAllSpeakingAssessmentsByUserId(userId);
    }

    @PostMapping("/create")
    public ResponseEntity<SpeakingAssessment> createEntity(@RequestBody SpeakingAssessment entity) {
        return speakingAssessmentService.createEntity(entity);
    }

    @PostMapping("/update")
    public ResponseEntity<SpeakingAssessment> updateEntity(@RequestBody SpeakingAssessment entity) {
        return speakingAssessmentService.updateEntity(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable int id) {
        return speakingAssessmentService.deleteEntity(id);
    }

}
