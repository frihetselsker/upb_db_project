package com.langlearning.crud.repository.quizzes;

import com.langlearning.crud.entity.quizzes.QuizOption;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizOptionRepository extends MongoRepository<QuizOption, String> {
    QuizOption findByOptionId(int optionId);
    void deleteByOptionId(int optionId);
}
