package com.langlearning.crud.service;

import com.langlearning.crud.entity.feedback.UserFeedback;
import com.langlearning.crud.entity.user.User;
import com.langlearning.crud.repository.feedback.UserFeedbackRepository;
import com.langlearning.crud.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.langlearning.crud.utilities.CopyManager.getNullPropertyNames;

@Service
@RequiredArgsConstructor
public class UserFeedbackService {
    @Autowired
    private UserFeedbackRepository userFeedbackRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<UserFeedback>> getAllUserFeedback() {
        return ResponseEntity.ok(userFeedbackRepository.findAll());
    }

    public ResponseEntity<UserFeedback> getEntityById(int feedbackId) {
        UserFeedback userFeedback = userFeedbackRepository.findByFeedbackId(feedbackId);
        if (userFeedback != null) {
            return ResponseEntity.ok(userFeedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<UserFeedback> createEntity(UserFeedback entity) {
        entity.setFeedbackId(sequenceGeneratorService.generateSequence("user_feedback_sequence"));
        if (entity.getUserId() != 0) {
            if (userRepository.findByUserId(entity.getUserId()) == null) {
                return ResponseEntity.badRequest().build();
            } else {
                userFeedbackRepository.save(entity);
                return ResponseEntity.ok(entity);
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Void> deleteEntity(int feedbackId) {
        if (userFeedbackRepository.findByFeedbackId(feedbackId) != null) {
            userFeedbackRepository.deleteByFeedbackId(feedbackId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<UserFeedback> updateEntity(UserFeedback entity) {
        Optional<UserFeedback> userFeedbackOptional = Optional.ofNullable(userFeedbackRepository.findByFeedbackId(entity.getFeedbackId()));
        if (userFeedbackOptional.isPresent()) {
            UserFeedback existingUserFeedback = userFeedbackOptional.get();
            BeanUtils.copyProperties(entity, existingUserFeedback, getNullPropertyNames(entity));
            if(entity.getUserId() != 0) {
                if (userRepository.findByUserId(entity.getUserId()) == null) {
                    return ResponseEntity.badRequest().build();
                }
            }
            userFeedbackRepository.save(existingUserFeedback);
            return ResponseEntity.ok(existingUserFeedback);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<UserFeedback>> getAllUserFeedbackByUserId(int userId){
        if (userRepository.findByUserId(userId) == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(userFeedbackRepository.findByUserId(userId));
        }
    }


}
