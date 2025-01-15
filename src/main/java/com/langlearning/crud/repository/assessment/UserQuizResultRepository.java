package com.langlearning.crud.repository.assessment;

import com.langlearning.crud.entity.assessment.UserQuizResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserQuizResultRepository extends MongoRepository<UserQuizResult, String> {
    List<UserQuizResult> findUserQuizResultsByUserId(int userId);
    List<UserQuizResult> findUserQuizResultsByQuizId(int quizId);
    UserQuizResult findByResultId(int resultId);
    void deleteByResultId(int resultId);
}