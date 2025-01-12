package com.langlearning.crud.entity.quizzes;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "Quizzes")
public class Quiz {
    @Id
    private String id;
    private int quizId;
    private String title;
    private String difficultyLevel;
    private String languageCode;
    private int totalQuestions;
    private ArrayList<QuizQuestion> questions;
}
