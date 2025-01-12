package com.langlearning.crud.repository.quizzes;

import com.langlearning.crud.entity.quizzes.Quiz;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizRepository extends MongoRepository<Quiz, String> {
    List<Quiz> findByDifficultyLevel(String difficultyLevel);
}
