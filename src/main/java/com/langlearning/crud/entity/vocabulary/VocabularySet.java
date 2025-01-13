package com.langlearning.crud.entity.vocabulary;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.LinkedList;

@RequiredArgsConstructor
@Document(collection = "VocabularySets")
public class VocabularySet {
    @Id
    private String id;
    @Indexed(unique = true)
    private int vocabularySetId;
    private String title;
    private String languageCode;
    private String difficultyLevel;
    private LinkedList<VocabularyWord> vocabularyWords;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getVocabularySetId() {
        return vocabularySetId;
    }

    public void setVocabularySetId(int vocabularySetId) {
        this.vocabularySetId = vocabularySetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public String getDifficultyLevel() {
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }

    public LinkedList<VocabularyWord> getVocabularyWords() {
        return vocabularyWords;
    }

    public void setVocabularyWords(LinkedList<VocabularyWord> vocabularyWords) {
        this.vocabularyWords = vocabularyWords;
    }
}
