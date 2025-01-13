package com.langlearning.crud.entity.user;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LanguageProficiency {
    private int proficiencyId;
    private String languageCode;
    private String proficiencyLevel;
    private double speakingScore;
    private double writingScore;
    private double readingScore;
    private double listeningScore;

    public int getProficiencyId() {
        return proficiencyId;
    }

    public void setProficiencyId(int proficiencyId) {
        this.proficiencyId = proficiencyId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public double getSpeakingScore() {
        return speakingScore;
    }

    public void setSpeakingScore(double speakingScore) {
        this.speakingScore = speakingScore;
    }

    public double getWritingScore() {
        return writingScore;
    }

    public void setWritingScore(double writingScore) {
        this.writingScore = writingScore;
    }

    public double getReadingScore() {
        return readingScore;
    }

    public void setReadingScore(double readingScore) {
        this.readingScore = readingScore;
    }

    public double getListeningScore() {
        return listeningScore;
    }

    public void setListeningScore(double listeningScore) {
        this.listeningScore = listeningScore;
    }
}
