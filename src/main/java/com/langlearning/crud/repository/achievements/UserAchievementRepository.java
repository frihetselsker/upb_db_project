package com.langlearning.crud.repository.achievements;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.langlearning.crud.entity.achievements.UserAchievement;

import java.util.List;

@Repository
public interface UserAchievementRepository extends MongoRepository<UserAchievement, String> {
    List<UserAchievement> findByUserId(int userId);
    UserAchievement findByUserAchievementId(int userAchievementId);
    List<UserAchievement> findByAchievementId(int achievementId);
    void deleteByUserAchievementId(int userAchievementId);
}
