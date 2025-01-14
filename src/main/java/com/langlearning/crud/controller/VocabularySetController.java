package com.langlearning.crud.controller;

import com.langlearning.crud.entity.vocabulary.VocabularySet;
import com.langlearning.crud.entity.vocabulary.VocabularyWord;
import com.langlearning.crud.service.VocabularySetService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vocabulary-sets")
public class VocabularySetController {
    @Autowired
    private VocabularySetService vocabularySetService;

    @GetMapping("/all")
    public ResponseEntity<List<VocabularySet>> getAllVocabularySets() {
        return vocabularySetService.getAllVocabularySets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VocabularySet> getVocabularySetById(@PathVariable int id) {
        return vocabularySetService.getVocabularySetById(id);
    }

    @GetMapping("/create")
    public ResponseEntity<VocabularySet> createEntity(@RequestBody VocabularySet entity) {
        return vocabularySetService.createEntity(entity);
    }

    @PostMapping("/update")
    public ResponseEntity<VocabularySet> updateEntity(@RequestBody VocabularySet entity) {
        return vocabularySetService.updateEntity(entity);
    }

    @PostMapping("/update-word/{id}")
    public ResponseEntity<VocabularySet> updateWords(@RequestBody VocabularyWord word, @PathVariable int id) {
        return vocabularySetService.updateWord(id, word);
    }

    @PostMapping("/delete-word/{setId}/{wordId}")
    public ResponseEntity<VocabularySet> deleteWord(@PathVariable int setId, @PathVariable int wordId) {
        return vocabularySetService.deleteWord(setId, wordId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable int id) {
        return vocabularySetService.deleteEntity(id);
    }



}
