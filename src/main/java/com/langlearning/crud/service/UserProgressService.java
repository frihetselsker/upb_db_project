package com.langlearning.crud.service;

import com.langlearning.crud.entity.assessment.UserProgress;
import com.langlearning.crud.entity.feedback.UserFeedback;
import com.langlearning.crud.repository.assessment.UserProgressRepository;
import com.langlearning.crud.repository.course.LessonRepository;
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
public class UserProgressService {
    @Autowired
    private UserProgressRepository userProgressRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<UserProgress>> getAllUserProgress() {
        return ResponseEntity.ok(userProgressRepository.findAll());
    }

    public ResponseEntity<UserProgress> getUserProgressById(int progressId) {
        UserProgress userProgress = userProgressRepository.findUserProgressByProgressId(progressId);
        if (userProgress != null) {
            return ResponseEntity.ok(userProgress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<UserProgress>> getUserProgressByUserId(int userId) {
        if (userRepository.findByUserId(userId) == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(userProgressRepository.findUserProgressesByUserId(userId));
        }
    }

    public ResponseEntity<List<UserProgress>> getUserProgressByLessonId(int lessonId) {
        if (lessonRepository.findByLessonId(lessonId) == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(userProgressRepository.findUserProgressesByLessonId(lessonId));
        }
    }


    public ResponseEntity<UserProgress> createUserProgress(UserProgress entity) {
        entity.setProgressId(sequenceGeneratorService.generateSequence("user_progress_sequence"));
        if (entity.getUserId() != 0) {
            if (userRepository.findByUserId(entity.getUserId()) == null) {
                return ResponseEntity.badRequest().build();
            } else {
                if(entity.getLessonId() != 0){
                    if(lessonRepository.findByLessonId(entity.getLessonId()) == null){
                        return ResponseEntity.badRequest().build();
                    } else {
                        userProgressRepository.save(entity);
                        return ResponseEntity.ok(entity);
                    }
                } else {
                    return ResponseEntity.badRequest().build();
                }
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<UserProgress> updateUserProgress(UserProgress entity) {
        Optional<UserProgress> userProgressOptional = Optional.ofNullable(userProgressRepository.findUserProgressByProgressId(entity.getProgressId()));
        if (userProgressOptional.isPresent()) {
            UserProgress existingUserProgress = userProgressOptional.get();
            BeanUtils.copyProperties(entity, existingUserProgress, getNullPropertyNames(entity));
            if(entity.getUserId() != 0) {
                if (userRepository.findByUserId(entity.getUserId()) == null) {
                    return ResponseEntity.badRequest().build();
                }
            }
            if (entity.getLessonId() != 0) {
                if (lessonRepository.findByLessonId(entity.getLessonId()) == null) {
                    return ResponseEntity.badRequest().build();
                }
            }
            userProgressRepository.save(existingUserProgress);
            return ResponseEntity.ok(existingUserProgress);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteUserProgress(int progressId) {
        if (userProgressRepository.findUserProgressByProgressId(progressId) != null) {
            userProgressRepository.deleteByProgressId(progressId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}