package com.langlearning.crud.repository.vocabulary;

import com.langlearning.crud.entity.vocabulary.VocabularySet;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface VocabularySetRepository extends MongoRepository<VocabularySet, String> {
}
