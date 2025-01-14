package com.langlearning.crud.controller;

import com.langlearning.crud.entity.achievements.Achievement;
import com.langlearning.crud.service.AchievementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {
    private AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Achievement>> getAllAchievements() {
        return achievementService.getAllAchievements();
    }

    @PostMapping("/create")
    public ResponseEntity<Achievement> createEntity(Achievement entity) {
        return achievementService.createEntity(entity);
    }

    @PostMapping("/update")
    public ResponseEntity<Achievement> updateEntity(Achievement entity) {
        return achievementService.updateEntity(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(int id) {
        return achievementService.deleteEntity(id);
    }



}
