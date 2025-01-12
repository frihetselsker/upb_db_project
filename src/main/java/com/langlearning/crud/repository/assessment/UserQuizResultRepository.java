package com.langlearning.crud.repository.assessment;

import com.langlearning.crud.entity.assessment.UserQuizResult;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserQuizResultRepository extends MongoRepository<UserQuizResult, String> {
    List<UserQuizResult> findByUserIdAndQuizId(String userId, int quizId);
}
