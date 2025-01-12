package com.langlearning.crud.entity.user;

import lombok.Data;

@Data
public class LanguageProficiency {
    private int proficiencyId;
    private String languageCode;
    private String proficiencyLevel;
    private double speakingScore;
    private double writingScore;
    private double readingScore;
    private double listeningScore;
}
