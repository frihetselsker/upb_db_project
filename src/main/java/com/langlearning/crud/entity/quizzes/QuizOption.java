package com.langlearning.crud.entity.quizzes;

import lombok.Data;

@Data
public class QuizOption {
    private int optionId;
    private String optionText;
    private boolean isCorrect;
}
