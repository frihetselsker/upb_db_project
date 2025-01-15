package com.langlearning.crud.controller;

import com.langlearning.crud.entity.assessment.UserProgress;
import com.langlearning.crud.service.UserProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-progress")
@RequiredArgsConstructor
public class UserProgressController {
    private final UserProgressService userProgressService;

    @GetMapping("/all")
    public List<UserProgress> getAllUserProgress() {
        return userProgressService.getAllUserProgress();
    }

    @GetMapping("/{achievementId}/{tutorId}")
    public ResponseEntity<UserProgress> getUserProgressByIds(@PathVariable String achievementId, @PathVariable String tutorId) {
        Optional<UserProgress> userProgress = userProgressService.getUserProgressByIds(achievementId, tutorId);
        return userProgress.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public UserProgress createUserProgress(@RequestBody UserProgress userProgress) {
        return userProgressService.createUserProgress(userProgress);
    }

    @PutMapping("/update")
    public UserProgress updateUserProgress(@RequestBody UserProgress userProgress) {
        return userProgressService.updateUserProgress(userProgress);
    }

    @DeleteMapping("/delete/{achievementId}/{tutorId}")
    public ResponseEntity<Void> deleteUserProgress(@PathVariable String achievementId, @PathVariable String tutorId) {
        userProgressService.deleteUserProgress(achievementId, tutorId);
        return ResponseEntity.noContent().build();
    }
}