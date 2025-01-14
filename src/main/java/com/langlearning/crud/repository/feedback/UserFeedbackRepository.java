package com.langlearning.crud.repository.feedback;

import com.langlearning.crud.entity.feedback.UserFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserFeedbackRepository extends MongoRepository<UserFeedback, String> {
    Optional<UserFeedback> findByAchievementIdAndTutorId(String achievementId, String tutorId);
    void deleteByAchievementIdAndTutorId(String achievementId, String tutorId);
}