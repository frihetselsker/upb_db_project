package com.langlearning.crud.controller;

import com.langlearning.crud.entity.achievements.UserAchievement;
import com.langlearning.crud.service.UserAchievementService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-achievements")
public class UserAchievementController {
    @Autowired
    private final UserAchievementService userAchievementService;

    public UserAchievementController(UserAchievementService userAchievementService) {
        this.userAchievementService = userAchievementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserAchievement>> getAllUserAchievements() {
        return userAchievementService.getAllUserAchievements();
    }

    @PostMapping("/create")
    public ResponseEntity<UserAchievement> createUserAchievement(@RequestBody UserAchievement entity) {
        return userAchievementService.createUserAchievement(entity);
    }

    @PostMapping("/update")
    public ResponseEntity<UserAchievement> updateUserAchievement(@RequestBody UserAchievement entity) {
        return userAchievementService.updateUserAchievement(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserAchievement(@PathVariable int id) {
        return userAchievementService.deleteUserAchievement(id);
    }
}
