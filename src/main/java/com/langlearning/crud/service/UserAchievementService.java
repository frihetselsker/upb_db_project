package com.langlearning.crud.service;

import com.langlearning.crud.entity.achievements.UserAchievement;
import com.langlearning.crud.repository.achievements.UserAchievementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserAchievementService {
    @Autowired
    private UserAchievementRepository userAchievementRepository;

    public List<UserAchievement> getAllUserAchievements() {
        return userAchievementRepository.findAll();
    }
}
