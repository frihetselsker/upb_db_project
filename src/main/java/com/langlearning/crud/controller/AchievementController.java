package com.langlearning.crud.controller;

import com.langlearning.crud.entity.achievements.Achievement;
import com.langlearning.crud.service.AchievementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/achievements")
public class AchievementController {
    @Autowired
    private AchievementService achievementService;

    public AchievementController(AchievementService achievementService) {
        this.achievementService = achievementService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Achievement>> getAllAchievements() {
        return achievementService.getAllAchievements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Achievement> getAchievementById(@PathVariable int id) {
        return achievementService.getAchievementById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Achievement> createAchievement(@RequestBody Achievement entity) {
        return achievementService.createAchievement(entity);
    }

    @PostMapping("/update")
    public ResponseEntity<Achievement> updateAchievement(@RequestBody Achievement entity) {
        return achievementService.updateAchievement(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAchievement(@PathVariable int id) {
        return achievementService.deleteAchievement(id);
    }
}
