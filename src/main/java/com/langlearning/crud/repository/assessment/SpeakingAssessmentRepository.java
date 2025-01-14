package com.langlearning.crud.repository.assessment;

import com.langlearning.crud.entity.assessment.SpeakingAssessment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SpeakingAssessmentRepository extends MongoRepository<SpeakingAssessment, String> {
    Optional<SpeakingAssessment> findByAchievementIdAndTutorId(String achievementId, String tutorId);
    void deleteByAchievementIdAndTutorId(String achievementId, String tutorId);
}