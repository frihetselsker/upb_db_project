package com.langlearning.crud.controller;

import com.langlearning.crud.entity.assessment.UserProgress;
import com.langlearning.crud.service.UserProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-progress")
@RequiredArgsConstructor
public class UserProgressController {
    @Autowired
    private UserProgressService userProgressService;

    @GetMapping("/all")
    public ResponseEntity<List<UserProgress>> getAllUserProgress() {
        return userProgressService.getAllUserProgress();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProgress> getUserProgressById(@PathVariable int id) {
        return userProgressService.getUserProgressById(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserProgress>> getUserProgressByUserId(@PathVariable int userId) {
        return userProgressService.getUserProgressByUserId(userId);
    }

    @GetMapping("/lesson/{lessonId}")
    public ResponseEntity<List<UserProgress>> getUserProgressByLessonId(@PathVariable int lessonId) {
        return userProgressService.getUserProgressByLessonId(lessonId);
    }

    @PostMapping("/create")
    public ResponseEntity<UserProgress> createUserProgress(@RequestBody UserProgress userProgress) {
        return userProgressService.createUserProgress(userProgress);
    }

    @PutMapping("/update")
    public ResponseEntity<UserProgress> updateUserProgress(@RequestBody UserProgress userProgress) {
        return userProgressService.updateUserProgress(userProgress);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserProgress(@PathVariable int id) {
        return userProgressService.deleteUserProgress(id);
    }
}