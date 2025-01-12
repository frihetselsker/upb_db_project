package com.langlearning.crud.entity.achievements;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Achievements")
public class Achievement {
    @Id
    private int id;
    private int achievementId;
    private String title;
    private String description;
    private String badgeIconUrl;
}
