package com.langlearning.crud.repository.achievements;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.langlearning.crud.entity.achievements.UserAchievement;

@Repository
public interface UserAchievementRepository extends MongoRepository<UserAchievement, String> {
    UserAchievement findByUserAchievementId(int userAchievementId);
    void deleteByUserAchievementId(int userAchievementId);
}
