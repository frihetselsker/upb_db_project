package com.langlearning.crud.repository.assessment;

import com.langlearning.crud.entity.assessment.UserProgress;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserProgressRepository extends MongoRepository<UserProgress, String> {
    Optional<UserProgress> findByAchievementIdAndTutorId(String achievementId, String tutorId);
    void deleteByAchievementIdAndTutorId(String achievementId, String tutorId);
}