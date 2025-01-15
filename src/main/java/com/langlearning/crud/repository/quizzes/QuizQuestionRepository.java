package com.langlearning.crud.repository.quizzes;

import com.langlearning.crud.entity.quizzes.QuizQuestion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizQuestionRepository extends MongoRepository<QuizQuestion, String> {
    QuizQuestion findByQuestionId(int questionId);
    void deleteByQuestionId(int questionId);
}
