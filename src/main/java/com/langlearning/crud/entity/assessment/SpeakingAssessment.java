package com.langlearning.crud.entity.assessment;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
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
}
