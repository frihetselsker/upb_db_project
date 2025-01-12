package com.langlearning.crud.controller;

import com.langlearning.crud.service.VocabularySetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vocabulary-sets")
public class VocabularySetController {
    @Autowired
    private VocabularySetService vocabularySetService;

    @GetMapping("/all")
    public Object getAllVocabularySets() {
        return vocabularySetService.getAllVocabularySets();
    }
}
