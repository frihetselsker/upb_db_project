package com.langlearning.crud.service;

import com.langlearning.crud.entity.achievements.UserAchievement;
import com.langlearning.crud.repository.achievements.UserAchievementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserAchievementService {
    @Autowired
    private UserAchievementRepository userAchievementRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<UserAchievement>> getAllUserAchievements() {
        return ResponseEntity.ok(userAchievementRepository.findAll());
    }

    public ResponseEntity<UserAchievement> createUserAchievement(UserAchievement entity) {
        entity.setUserAchievementId(sequenceGeneratorService.generateSequence("user_achievement_sequence"));
        userAchievementRepository.save(entity);
        return ResponseEntity.ok(entity);
    }

    public ResponseEntity<Void> deleteUserAchievement(int userAchievementId) {
        Optional<UserAchievement> userAchievement = Optional.ofNullable(userAchievementRepository.findByUserAchievementId(userAchievementId));
        if (userAchievement.isPresent()) {
            userAchievementRepository.deleteByUserAchievementId(userAchievementId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<UserAchievement> updateUserAchievement(UserAchievement entity) {
        Optional<UserAchievement> userAchievementOptional = Optional.ofNullable(userAchievementRepository.findByUserAchievementId(entity.getUserAchievementId()));
        if (userAchievementOptional.isPresent()) {
            UserAchievement existingUserAchievement = userAchievementOptional.get();
            BeanUtils.copyProperties(entity, existingUserAchievement, getNullPropertyNames(entity));
            userAchievementRepository.save(existingUserAchievement);
            return ResponseEntity.ok(existingUserAchievement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
