package com.langlearning.crud.repository.vocabulary;

import com.langlearning.crud.entity.vocabulary.VocabularySet;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VocabularySetRepository extends MongoRepository<VocabularySet, String> {
    List<VocabularySet> findByName(String name);
    List<VocabularySet> findByLanguage(String language);
    List<VocabularySet> findByDescription(String description);
}
