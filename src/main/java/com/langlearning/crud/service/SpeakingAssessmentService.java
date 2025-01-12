package com.langlearning.crud.service;

import com.langlearning.crud.repository.assessment.SpeakingAssessmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpeakingAssessmentService {

    @Autowired
    private SpeakingAssessmentRepository speakingAssessmentRepository;

    public Object getAllSpeakingAssessments() {
        return speakingAssessmentRepository.findAll();
    }
}
