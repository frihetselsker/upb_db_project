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

    @GetMapping("{id}")
    public ResponseEntity<Achievement> getEntityById(@PathVariable int id) {
        return achievementService.getEntityById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Achievement> createEntity(@RequestBody Achievement entity) {
        return achievementService.createEntity(entity);
    }

    @PutMapping("/update")
    public ResponseEntity<Achievement> updateEntity(@RequestBody Achievement entity) {
        return achievementService.updateEntity(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable int id) {
        return achievementService.deleteEntity(id);
    }



}
