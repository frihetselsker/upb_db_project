package com.langlearning.crud.controller;

import com.langlearning.crud.entity.achievements.UserAchievement;
import com.langlearning.crud.service.UserAchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user-achievements")
public class UserAchievementController {
    private final UserAchievementService userAchievementService;

    public UserAchievementController(UserAchievementService userAchievementService) {
        this.userAchievementService = userAchievementService;
    }

    @GetMapping("/all")
    public List<UserAchievement> getAllUserAchievements() {
        return userAchievementService.getAllUserAchievements();
    }
}
