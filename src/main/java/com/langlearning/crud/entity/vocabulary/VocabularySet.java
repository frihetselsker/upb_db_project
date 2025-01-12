package com.langlearning.crud.entity.vocabulary;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;

@Data
@Document(collection = "VocabularySets")
public class VocabularySet {
    @Id
    private String id;
    private int vocabularySetId;
    private String title;
    private String languageCode;
    private String difficultyLevel;
    private LinkedList<VocabularyWord> vocabularyWords;
}
