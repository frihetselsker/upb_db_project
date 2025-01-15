package com.langlearning.crud.repository.quizzes;

import com.langlearning.crud.entity.quizzes.QuizQuestion;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizQuestionRepository extends MongoRepository<QuizQuestion, String> {
    QuizQuestion findByQuestionId(int questionId);
    List<QuizQuestion> findQuizQuestionsByQuizId(int quizId);
    void deleteQuizQuestionsByQuizId(int quizId);
    void deleteByQuestionId(int questionId);
}
