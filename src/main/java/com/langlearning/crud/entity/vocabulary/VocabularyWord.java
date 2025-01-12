package com.langlearning.crud.entity.vocabulary;

import lombok.Data;

@Data
public class VocabularyWord {
    private int wordId;
    private String word;
    private String translation;
    private String exampleSentence;
    private String pronunciationUrl;
}
