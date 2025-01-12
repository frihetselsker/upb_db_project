package com.langlearning.crud.service;

import com.langlearning.crud.repository.vocabulary.VocabularySetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VocabularySetService {
    @Autowired
    private VocabularySetRepository vocabularySetRepository;

    public Object getAllVocabularySets() {
        return vocabularySetRepository.findAll();
    }
}
