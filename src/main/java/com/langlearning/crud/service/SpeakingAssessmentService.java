package com.langlearning.crud.service;

import com.langlearning.crud.entity.assessment.SpeakingAssessment;
import com.langlearning.crud.repository.assessment.SpeakingAssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SpeakingAssessmentService {
    @Autowired
    private final SpeakingAssessmentRepository speakingAssessmentRepository;

    public ResponseEntity<List<SpeakingAssessment>> getAllSpeakingAssessments() {
        return ResponseEntity.ok(speakingAssessmentRepository.findAll());
    }

    public ResponseEntity<SpeakingAssessment> getSpeakingAssessmentByIds(String achievementId, String tutorId) {
        Optional<SpeakingAssessment> speakingAssessment = speakingAssessmentRepository.findByAchievementIdAndTutorId(achievementId, tutorId);
        return speakingAssessment.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<SpeakingAssessment> createSpeakingAssessment(SpeakingAssessment speakingAssessment) {
        return ResponseEntity.ok(speakingAssessmentRepository.save(speakingAssessment));
    }

    public ResponseEntity<SpeakingAssessment> updateSpeakingAssessment(SpeakingAssessment speakingAssessment) {
        return ResponseEntity.ok(speakingAssessmentRepository.save(speakingAssessment));
    }

    public ResponseEntity<Void> deleteSpeakingAssessment(String achievementId, String tutorId) {
        speakingAssessmentRepository.deleteByAchievementIdAndTutorId(achievementId, tutorId);
        return ResponseEntity.noContent().build();
    }
}