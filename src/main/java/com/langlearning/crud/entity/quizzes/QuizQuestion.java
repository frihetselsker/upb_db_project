package com.langlearning.crud.entity.quizzes;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;

@RequiredArgsConstructor
public class QuizQuestion {
    private int questionId;
    private String questionText;
    private String questionType;
    private ArrayList<QuizOption> options;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public ArrayList<QuizOption> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<QuizOption> options) {
        this.options = options;
    }
}
