package com.langlearning.crud.service;

import com.langlearning.crud.entity.achievements.Achievement;
import com.langlearning.crud.entity.ai.AITutor;
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

import static com.langlearning.crud.utilities.CopyManager.getNullPropertyNames;

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

    public ResponseEntity<Achievement> getEntityById(int achievementId) {
        Achievement achievement = achievementRepository.findByAchievementId(achievementId);
        if (achievement != null) {
            return ResponseEntity.ok(achievement);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Achievement> createEntity(Achievement entity) {
        entity.setAchievementId(sequenceGeneratorService.generateSequence("achievement_sequence"));
        achievementRepository.save(entity);
        return ResponseEntity.ok(entity);
    }

    public ResponseEntity<Void> deleteEntity(int achievementId) {
        achievementRepository.deleteByAchievementId(achievementId);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Achievement> updateEntity(Achievement entity) {
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
}
