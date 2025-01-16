package com.langlearning.crud.controller;

import com.langlearning.crud.entity.achievements.UserAchievement;
import com.langlearning.crud.service.UserAchievementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-achievements")
public class UserAchievementController {
    private final UserAchievementService userAchievementService;

    public UserAchievementController(UserAchievementService userAchievementService) {
        this.userAchievementService = userAchievementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserAchievement>> getAllUserAchievements() {
        return userAchievementService.getAllUserAchievements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserAchievement> getEntityById(@PathVariable int id) {
        return userAchievementService.getUserAchievementById(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserAchievement>> getAchievementsByUserId(@PathVariable int userId) {
        return userAchievementService.getUserAchievementByUserId(userId);
    }

    @GetMapping("/achievement/{achievementId}")
    public ResponseEntity<List<UserAchievement>> getAchievementsByAchievementId(@PathVariable int achievementId) {
        return userAchievementService.getUserAchievementByAchievementId(achievementId);
    }

    @PostMapping("/create")
    public ResponseEntity<UserAchievement> createEntity(@RequestBody UserAchievement entity) {
        return userAchievementService.createEntity(entity);
    }

    @PostMapping("/update")
    public ResponseEntity<UserAchievement> updateEntity(@RequestBody UserAchievement entity) {
        return userAchievementService.updateEntity(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable int id) {
        return userAchievementService.deleteEntity(id);
    }
}
