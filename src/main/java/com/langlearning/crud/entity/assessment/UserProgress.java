package com.langlearning.crud.entity.assessment;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "UserProgress")
public class UserProgress {
    @Id
    private String id;
    private int progressId;
    private int userId;
    private int lessonId;
    private String status;
    private Date startedAt;
    private Date completedAt;
    private int completionPercentage;
}
