package com.langlearning.crud.repository.achievements;

import com.langlearning.crud.entity.achievements.Achievement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AchievementRepository extends MongoRepository<Achievement, String> {
    void deleteByAchievementId(int achievementId);
    Achievement findByAchievementId(int achievementId);
}
