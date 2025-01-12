package com.langlearning.crud.controller;

import com.langlearning.crud.service.VocabularySetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vocabulary-sets")
public class VocabularySetController {
    private final VocabularySetService vocabularySetService;

    public VocabularySetController(VocabularySetService vocabularySetService) {
        this.vocabularySetService = vocabularySetService;
    }

    @GetMapping("/all")
    public Object getAllVocabularySets() {
        return vocabularySetService.getAllVocabularySets();
    }
}
