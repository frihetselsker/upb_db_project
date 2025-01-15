package com.langlearning.crud.service;

import com.langlearning.crud.entity.assessment.UserProgress;
import com.langlearning.crud.entity.assessment.UserQuizResult;
import com.langlearning.crud.repository.assessment.UserQuizResultRepository;
import com.langlearning.crud.repository.quizzes.QuizRepository;
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
public class UserQuizResultService {
    @Autowired
    private UserQuizResultRepository userQuizResultRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuizRepository quizRepository;

    public ResponseEntity<List<UserQuizResult>> getAllUserQuizResults() {
        return ResponseEntity.ok(userQuizResultRepository.findAll());
    }

    public ResponseEntity<UserQuizResult> getUserQuizResultById(int resultId) {
        UserQuizResult userQuizResult = userQuizResultRepository.findByResultId(resultId);
        if (userQuizResult != null) {
            return ResponseEntity.ok(userQuizResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<UserQuizResult>> getUserQuizResultsByUserId(int userId) {
        if (userRepository.findByUserId(userId) == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(userQuizResultRepository.findUserQuizResultsByUserId(userId));
        }
    }

    public ResponseEntity<List<UserQuizResult>> getUserQuizResultsByQuizId(int quizId) {
        if (quizRepository.findByQuizId(quizId) == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(userQuizResultRepository.findUserQuizResultsByQuizId(quizId));
        }
    }

    public ResponseEntity<UserQuizResult> createUserQuizResult(UserQuizResult userQuizResult) {
        userQuizResult.setResultId(sequenceGeneratorService.generateSequence("user_quiz_result_sequence"));
        if (userQuizResult.getQuizId() != 0) {
            if (quizRepository.findByQuizId(userQuizResult.getQuizId()) == null) {
                return ResponseEntity.badRequest().build();
            } else {
                if (userQuizResult.getUserId() != 0) {
                    if (userRepository.findByUserId(userQuizResult.getUserId()) == null) {
                        return ResponseEntity.badRequest().build();
                    } else {
                        userQuizResultRepository.save(userQuizResult);
                        return ResponseEntity.ok(userQuizResult);
                    }
                } else {
                    return ResponseEntity.badRequest().build();
                }
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Void> deleteUserQuizResult(int resultId) {
        if (userQuizResultRepository.findByResultId(resultId) != null) {
            userQuizResultRepository.deleteByResultId(resultId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<UserQuizResult> updateUserQuizResult(UserQuizResult entity) {
        Optional<UserQuizResult> userQuizResultOptional = Optional.ofNullable(userQuizResultRepository.findByResultId(entity.getResultId()));
        if (userQuizResultOptional.isPresent()) {
            UserQuizResult existingUserQuizResult = userQuizResultOptional.get();
            BeanUtils.copyProperties(entity, existingUserQuizResult, getNullPropertyNames(entity));
            if(entity.getUserId() != 0) {
                if (userRepository.findByUserId(entity.getUserId()) == null) {
                    return ResponseEntity.badRequest().build();
                }
            }
            if (entity.getQuizId() != 0) {
                if (quizRepository.findByQuizId(entity.getQuizId()) == null) {
                    return ResponseEntity.badRequest().build();
                }
            }
            userQuizResultRepository.save(existingUserQuizResult);
            return ResponseEntity.ok(existingUserQuizResult);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}