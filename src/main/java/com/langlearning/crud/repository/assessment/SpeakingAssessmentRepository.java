package com.langlearning.crud.repository.assessment;

import com.langlearning.crud.entity.assessment.SpeakingAssessment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakingAssessmentRepository extends MongoRepository<SpeakingAssessment, String> {

}
