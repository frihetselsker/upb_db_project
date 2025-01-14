package com.langlearning.crud.repository.assessment;

import com.langlearning.crud.entity.assessment.UserQuizResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserQuizResultRepository extends MongoRepository<UserQuizResult, String> {
    Optional<UserQuizResult> findByAchievementIdAndTutorId(String achievementId, String tutorId);
    void deleteByAchievementIdAndTutorId(String achievementId, String tutorId);
}