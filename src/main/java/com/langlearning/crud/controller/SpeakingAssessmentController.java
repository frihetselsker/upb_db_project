package com.langlearning.crud.controller;

import com.langlearning.crud.entity.assessment.SpeakingAssessment;
import com.langlearning.crud.service.SpeakingAssessmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/speaking-assessment")
@RequiredArgsConstructor
public class SpeakingAssessmentController {
    @Autowired
    private final SpeakingAssessmentService speakingAssessmentService;

    @GetMapping("/all")
    public ResponseEntity<List<SpeakingAssessment>> getAllSpeakingAssessments() {
        return speakingAssessmentService.getAllSpeakingAssessments();
    }

    @GetMapping("/{achievementId}/{tutorId}")
    public ResponseEntity<SpeakingAssessment> getSpeakingAssessmentByIds(@PathVariable String achievementId, @PathVariable String tutorId) {
        return speakingAssessmentService.getSpeakingAssessmentByIds(achievementId, tutorId);
    }

    @PostMapping("/create")
    public ResponseEntity<SpeakingAssessment> createSpeakingAssessment(@RequestBody SpeakingAssessment speakingAssessment) {
        return speakingAssessmentService.createSpeakingAssessment(speakingAssessment);
    }

    @PutMapping("/update")
    public ResponseEntity<SpeakingAssessment> updateSpeakingAssessment(@RequestBody SpeakingAssessment speakingAssessment) {
        return speakingAssessmentService.updateSpeakingAssessment(speakingAssessment);
    }

    @DeleteMapping("/delete/{achievementId}/{tutorId}")
    public ResponseEntity<Void> deleteSpeakingAssessment(@PathVariable String achievementId, @PathVariable String tutorId) {
        return speakingAssessmentService.deleteSpeakingAssessment(achievementId, tutorId);
    }
}