package com.langlearning.crud.repository.achievements;

import com.langlearning.crud.entity.achievements.Achievement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends MongoRepository<Achievement, String> {
    Achievement findByAchievementId(int achievementId);
    void deleteByAchievementId(int achievementId);
}
