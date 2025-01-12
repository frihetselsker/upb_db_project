package com.langlearning.crud.controller;

import com.langlearning.crud.entity.achievements.Achievement;
import com.langlearning.crud.service.AchievementService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {
    private AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("/all")
    public List<Achievement> getAllAchievements() {
        return achievementService.getAllAchievements();
    }
}
