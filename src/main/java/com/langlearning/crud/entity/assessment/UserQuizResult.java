package com.langlearning.crud.entity.assessment;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "UserQuizResults")
public class UserQuizResult {
    @Id
    private String id;
    private int resultId;
    private int userId;
    private int quizId;
    private int totalQuestions;
    private int correctAnswers;
    private double scorePercentage;
    private Date completedAt;
}
