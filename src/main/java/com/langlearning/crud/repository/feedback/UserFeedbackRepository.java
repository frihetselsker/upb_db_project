package com.langlearning.crud.repository.feedback;

import com.langlearning.crud.entity.feedback.UserFeedback;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserFeedbackRepository extends MongoRepository<UserFeedback, String> {
    UserFeedback findByFeedbackId(int feedbackId);
    List<UserFeedback> findByUserId(int userId);
    void deleteByFeedbackId(int feedbackId);

}
