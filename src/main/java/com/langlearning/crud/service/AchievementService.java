package com.langlearning.crud.service;

import com.langlearning.crud.entity.achievements.Achievement;
import com.langlearning.crud.repository.achievements.AchievementRepository;
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
public class AchievementService {
    @Autowired
    private AchievementRepository achievementRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<Achievement>> getAllAchievements() {
        return ResponseEntity.ok(achievementRepository.findAll());
    }

    public ResponseEntity<Achievement> getAchievementById(int AchievementId) {
        Optional<Achievement> achievement = Optional.ofNullable(achievementRepository.findByAchievementId(AchievementId));
        return achievement.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Achievement> createAchievement(Achievement entity) {
        entity.setAchievementId(sequenceGeneratorService.generateSequence("achievement_sequence"));
        achievementRepository.save(entity);
        return ResponseEntity.ok(entity);
    }

    public ResponseEntity<Void> deleteAchievement(int AchievementId) {
        Optional<Achievement> achievement = Optional.ofNullable(achievementRepository.findByAchievementId(AchievementId));
        if (achievement.isPresent()) {
            achievementRepository.deleteByAchievementId(AchievementId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Achievement> updateAchievement(Achievement entity) {
        Optional<Achievement> achievementOptional = Optional.ofNullable(achievementRepository.findByAchievementId(entity.getAchievementId()));
        if (achievementOptional.isPresent()) {
            Achievement existingAchievement = achievementOptional.get();
            BeanUtils.copyProperties(entity, existingAchievement, getNullPropertyNames(entity));
            achievementRepository.save(existingAchievement);
            return ResponseEntity.ok(existingAchievement);
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
