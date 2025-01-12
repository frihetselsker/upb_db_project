package com.langlearning.crud.service;

import com.langlearning.crud.entity.achievements.Achievement;
import com.langlearning.crud.repository.achievements.AchievementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AchievementService {
    @Autowired
    private AchievementRepository achievementRepository;

    public List<Achievement> getAllAchievements() {
        return achievementRepository.findAll();
    }
}
