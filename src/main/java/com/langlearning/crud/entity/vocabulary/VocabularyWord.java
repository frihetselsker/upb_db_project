package com.langlearning.crud.entity.vocabulary;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class VocabularyWord {
    private int wordId;
    private String word;
    private String translation;
    private String exampleSentence;
    private String pronunciationUrl;

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    public String getPronunciationUrl() {
        return pronunciationUrl;
    }

    public void setPronunciationUrl(String pronunciationUrl) {
        this.pronunciationUrl = pronunciationUrl;
    }
}
