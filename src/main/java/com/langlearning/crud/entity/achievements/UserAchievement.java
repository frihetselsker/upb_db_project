package com.langlearning.crud.entity.achievements;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "UserAchievements")
public class UserAchievement {
    @Id
    private int id;
    private int userAchievementId;
    private int userId;
    private int achievementId;
    private Date earnedAt;
}
