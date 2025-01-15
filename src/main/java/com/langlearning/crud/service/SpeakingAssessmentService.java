package com.langlearning.crud.service;

import com.langlearning.crud.entity.assessment.SpeakingAssessment;
import com.langlearning.crud.entity.feedback.UserFeedback;
import com.langlearning.crud.repository.assessment.SpeakingAssessmentRepository;
import com.langlearning.crud.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.langlearning.crud.utilities.CopyManager.getNullPropertyNames;

@Service
@RequiredArgsConstructor
public class SpeakingAssessmentService {

    @Autowired
    private SpeakingAssessmentRepository speakingAssessmentRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<SpeakingAssessment>> getAllSpeakingAssessments() {
        return ResponseEntity.ok().body(speakingAssessmentRepository.findAll());
    }

    public ResponseEntity<SpeakingAssessment> getSpeakingAssessmentById(int id) {
        return ResponseEntity.ok().body(speakingAssessmentRepository.findByAssessmentId(id));
    }

   public ResponseEntity<List<SpeakingAssessment>> getAllSpeakingAssessmentsByUserId(int userId){
        if (userRepository.findByUserId(userId) == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().body(speakingAssessmentRepository.findByUserId(userId));
        }
   }

    public ResponseEntity<SpeakingAssessment> createEntity(SpeakingAssessment entity) {
        entity.setAssessmentId(sequenceGeneratorService.generateSequence("speaking_assessment_sequence"));
        if (entity.getUserId() != 0) {
            if (userRepository.findByUserId(entity.getUserId()) == null) {
                return ResponseEntity.badRequest().build();
            } else {
                speakingAssessmentRepository.save(entity);
                return ResponseEntity.ok().body(entity);
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Void> deleteEntity(int assessmentId) {
        if (speakingAssessmentRepository.findByAssessmentId(assessmentId) != null) {
            speakingAssessmentRepository.deleteByAssessmentId(assessmentId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<SpeakingAssessment> updateEntity(SpeakingAssessment entity) {
        Optional<SpeakingAssessment> speakingAssessmentOptional = Optional.ofNullable(speakingAssessmentRepository.findByAssessmentId(entity.getAssessmentId()));
        if (speakingAssessmentOptional.isPresent()) {
            SpeakingAssessment existingSpeakingAssessment = speakingAssessmentOptional.get();
            BeanUtils.copyProperties(entity, existingSpeakingAssessment, getNullPropertyNames(entity));
            if(entity.getUserId() != 0) {
                if (userRepository.findByUserId(entity.getUserId()) == null) {
                    return ResponseEntity.badRequest().build();
                }
            }
            speakingAssessmentRepository.save(existingSpeakingAssessment);
            return ResponseEntity.ok(existingSpeakingAssessment);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
