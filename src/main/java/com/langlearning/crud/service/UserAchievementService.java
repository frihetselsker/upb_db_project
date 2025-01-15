package com.langlearning.crud.service;

import com.langlearning.crud.entity.achievements.UserAchievement;
import com.langlearning.crud.entity.assessment.SpeakingAssessment;
import com.langlearning.crud.repository.achievements.AchievementRepository;
import com.langlearning.crud.repository.achievements.UserAchievementRepository;
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
public class UserAchievementService {
    @Autowired
    private UserAchievementRepository userAchievementRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<UserAchievement>> getAllUserAchievements() {
        return ResponseEntity.ok().body(userAchievementRepository.findAll());
    }

    public ResponseEntity<List<UserAchievement>> getUserAchievementByAchievementId(int achievementId) {
        if (achievementRepository.findByAchievementId(achievementId) == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().body(userAchievementRepository.findByAchievementId(achievementId));
        }
    }

    public ResponseEntity<UserAchievement> getUserAchievementById(int userAchievementId) {
        UserAchievement userAchievement = userAchievementRepository.findByUserAchievementId(userAchievementId);
        if (userAchievement != null) {
            return ResponseEntity.ok(userAchievement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<UserAchievement>> getUserAchievementByUserId(int userId) {
        if (userRepository.findByUserId(userId) == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok().body(userAchievementRepository.findByUserId(userId));
        }
    }

    public ResponseEntity<UserAchievement> createEntity(UserAchievement entity) {
        entity.setUserAchievementId(sequenceGeneratorService.generateSequence("user_achievement_sequence"));
        if (entity.getUserId() != 0 && entity.getAchievementId() != 0) {
            if (userRepository.findByUserId(entity.getUserId()) == null || achievementRepository.findByAchievementId(entity.getAchievementId()) == null) {
                return ResponseEntity.badRequest().build();
            } else {
                userAchievementRepository.save(entity);
                return ResponseEntity.ok().body(entity);
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Void> deleteEntity(int userAchievementId) {
        if (userAchievementRepository.findByUserAchievementId(userAchievementId) != null) {
            userAchievementRepository.deleteByUserAchievementId(userAchievementId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<UserAchievement> updateEntity(UserAchievement entity) {
        Optional<UserAchievement> userAchievementOptional = Optional.ofNullable(userAchievementRepository.findByUserAchievementId(entity.getUserAchievementId()));
        if (userAchievementOptional.isPresent()) {
            UserAchievement existingUserAchievement = userAchievementOptional.get();
            BeanUtils.copyProperties(entity, existingUserAchievement, getNullPropertyNames(entity));
            if(entity.getUserId() != 0) {
                if (userRepository.findByUserId(entity.getUserId()) == null) {
                    return ResponseEntity.badRequest().build();
                }
            }
            if(entity.getAchievementId() != 0) {
                if (achievementRepository.findByAchievementId(entity.getAchievementId()) == null) {
                    return ResponseEntity.badRequest().build();
                }
            }
            userAchievementRepository.save(existingUserAchievement);
            return ResponseEntity.ok(existingUserAchievement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
