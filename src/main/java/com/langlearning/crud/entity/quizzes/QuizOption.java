package com.langlearning.crud.entity.quizzes;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class QuizOption {
    private int optionId;
    private String optionText;
    private boolean isCorrect;

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
