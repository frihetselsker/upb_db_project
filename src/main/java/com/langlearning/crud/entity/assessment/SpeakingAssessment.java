package com.langlearning.crud.entity.assessment;

import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@Document(collection = "SpeakingAssessments")
public class SpeakingAssessment {
    @Id
    private String id;
    private int assessmentId;
    private int userId;
    private String languageCode;
    private String prompt;
    private String userAudioUrl;
    private double pronunciationScore;
    private double fluencyScore;
    private double grammarScore;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAssessmentId() {
        return assessmentId;
    }

    public void setAssessmentId(int assessmentId) {
        this.assessmentId = assessmentId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public String getUserAudioUrl() {
        return userAudioUrl;
    }

    public void setUserAudioUrl(String userAudioUrl) {
        this.userAudioUrl = userAudioUrl;
    }

    public double getPronunciationScore() {
        return pronunciationScore;
    }

    public void setPronunciationScore(double pronunciationScore) {
        this.pronunciationScore = pronunciationScore;
    }

    public double getFluencyScore() {
        return fluencyScore;
    }

    public void setFluencyScore(double fluencyScore) {
        this.fluencyScore = fluencyScore;
    }

    public double getGrammarScore() {
        return grammarScore;
    }

    public void setGrammarScore(double grammarScore) {
        this.grammarScore = grammarScore;
    }
}
