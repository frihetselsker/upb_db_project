package com.langlearning.crud.entity.quizzes;

import lombok.Data;

import java.util.ArrayList;

@Data
public class QuizQuestion {
    private int questionId;
    private String questionText;
    private String questionType;
    private ArrayList<QuizOption> options;
}
