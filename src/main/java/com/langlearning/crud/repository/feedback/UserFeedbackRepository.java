package com.langlearning.crud.repository.feedback;

import com.langlearning.crud.entity.feedback.UserFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFeedbackRepository extends MongoRepository<UserFeedback, String> {

}
