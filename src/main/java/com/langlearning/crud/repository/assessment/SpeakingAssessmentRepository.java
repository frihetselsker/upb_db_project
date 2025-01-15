package com.langlearning.crud.repository.assessment;

import com.langlearning.crud.entity.assessment.SpeakingAssessment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeakingAssessmentRepository extends MongoRepository<SpeakingAssessment, String> {
    SpeakingAssessment findByAssessmentId(int assessmentId);
    List<SpeakingAssessment> findByUserId(int userId);
    void deleteByAssessmentId(int assessmentId);
}
