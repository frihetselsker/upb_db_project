package com.langlearning.crud.service;

import com.langlearning.crud.entity.vocabulary.VocabularySet;
import com.langlearning.crud.entity.vocabulary.VocabularyWord;
import com.langlearning.crud.repository.vocabulary.VocabularySetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


import static com.langlearning.crud.utilities.CopyManager.getNullPropertyNames;

@Service
@RequiredArgsConstructor
public class VocabularySetService {
    @Autowired
    private VocabularySetRepository vocabularySetRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<VocabularySet>> getAllVocabularySets() {
        return ResponseEntity.ok(vocabularySetRepository.findAll());
    }

    public ResponseEntity<VocabularySet> getVocabularySetById(int id) {
        Optional<VocabularySet> vocabularySet = Optional.ofNullable(vocabularySetRepository.findByVocabularySetId(id));
        return vocabularySet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<VocabularySet> createEntity(VocabularySet entity) {
        entity.setVocabularySetId(sequenceGeneratorService.generateSequence("vocabulary_set_sequence"));
        vocabularySetRepository.save(entity);
        return ResponseEntity.ok(entity);
    }

    public ResponseEntity<Void> deleteEntity(int setId) {
        vocabularySetRepository.deleteByVocabularySetId(setId);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<VocabularySet> deleteWord(int setId, int wordId) {
        Optional<VocabularySet> vocabularySetOptional = Optional.ofNullable(vocabularySetRepository.findByVocabularySetId(setId));
        if (vocabularySetOptional.isPresent()) {
            VocabularySet existingVocabularySet = vocabularySetOptional.get();
            existingVocabularySet.getVocabularyWords().removeIf(vocabularyWord -> vocabularyWord.getWordId() == wordId);
            vocabularySetRepository.save(existingVocabularySet);
            return ResponseEntity.ok(existingVocabularySet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    public ResponseEntity<VocabularySet> updateEntity(VocabularySet entity) {
        Optional<VocabularySet> vocabularySetOptional = Optional.ofNullable(vocabularySetRepository.findByVocabularySetId(entity.getVocabularySetId()));
        if (vocabularySetOptional.isPresent()) {
            VocabularySet existingVocabularySet = vocabularySetOptional.get();
            BeanUtils.copyProperties(entity, existingVocabularySet, getNullPropertyNames(entity));
            vocabularySetRepository.save(existingVocabularySet);
            return ResponseEntity.ok(existingVocabularySet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<VocabularySet> updateWord(int vocabularySetId, VocabularyWord word) {
        Optional<VocabularySet> vocabularySetOptional = Optional.ofNullable(vocabularySetRepository.findByVocabularySetId(vocabularySetId));
        if (vocabularySetOptional.isPresent()) {
            VocabularySet existingVocabularySet = vocabularySetOptional.get();
            VocabularyWord existingVocabularyWord = existingVocabularySet.getVocabularyWords().stream()
                    .filter(vocabularyWord -> vocabularyWord.getWordId() == word.getWordId())
                    .findFirst()
                    .orElse(null);

            if (existingVocabularyWord == null) {
                existingVocabularyWord = new VocabularyWord();
                existingVocabularySet.getVocabularyWords().add(existingVocabularyWord);
            }
            int existingWordId = existingVocabularyWord.getWordId();
            BeanUtils.copyProperties(word, existingVocabularyWord, getNullPropertyNames(word));
            if (existingWordId != 0) {
                existingVocabularyWord.setWordId(existingWordId);
            } else {
                existingVocabularyWord.setWordId(sequenceGeneratorService.generateSequence("vocabulary_word_sequence"));
            }
            vocabularySetRepository.save(existingVocabularySet);
            return ResponseEntity.ok(existingVocabularySet);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
