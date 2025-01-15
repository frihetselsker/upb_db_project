package com.langlearning.crud.repository.quizzes;

import com.langlearning.crud.entity.quizzes.QuizOption;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizOptionRepository extends MongoRepository<QuizOption, String> {
    QuizOption findByOptionId(int optionId);
    List<QuizOption> findQuizOptionsByQuestionId(int questionId);
    void deleteQuizOptionsByQuestionId(int questionId);
    void deleteByOptionId(int optionId);
}
