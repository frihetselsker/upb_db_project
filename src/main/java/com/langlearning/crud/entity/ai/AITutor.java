package com.langlearning.crud.entity.ai;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "AITutors")
public class AITutor {
    @Id
    private int id;
    private int tutorId;
    private String tutorName;
    private String specializationLanguage;
    private String aiModelVersion;
    private boolean isActive;
}
