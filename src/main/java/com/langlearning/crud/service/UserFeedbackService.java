package com.langlearning.crud.service;

import com.langlearning.crud.entity.feedback.UserFeedback;
import com.langlearning.crud.repository.feedback.UserFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserFeedbackService {
    @Autowired
    private final UserFeedbackRepository userFeedbackRepository;

    public ResponseEntity<List<UserFeedback>> getAllUserFeedback() {
        return ResponseEntity.ok(userFeedbackRepository.findAll());
    }

    public ResponseEntity<UserFeedback> getUserFeedbackByIds(String achievementId, String tutorId) {
        Optional<UserFeedback> userFeedback = userFeedbackRepository.findByAchievementIdAndTutorId(achievementId, tutorId);
        return userFeedback.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<UserFeedback> createUserFeedback(UserFeedback userFeedback) {
        return ResponseEntity.ok(userFeedbackRepository.save(userFeedback));
    }

    public ResponseEntity<UserFeedback> updateUserFeedback(UserFeedback userFeedback) {
        return ResponseEntity.ok(userFeedbackRepository.save(userFeedback));
    }

    public ResponseEntity<Void> deleteUserFeedback(String achievementId, String tutorId) {
        userFeedbackRepository.deleteByAchievementIdAndTutorId(achievementId, tutorId);
        return ResponseEntity.noContent().build();
    }
}