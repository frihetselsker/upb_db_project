package com.langlearning.crud.repository.assessment;

import com.langlearning.crud.entity.assessment.UserProgress;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserProgressRepository extends MongoRepository<UserProgress, String> {
}
