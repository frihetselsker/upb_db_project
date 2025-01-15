package com.langlearning.crud.controller;

import com.langlearning.crud.entity.assessment.UserQuizResult;
import com.langlearning.crud.service.UserQuizResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-quiz-result")
@RequiredArgsConstructor
public class UserQuizResultController {
    private final UserQuizResultService userQuizResultService;

    @GetMapping("/all")
    public List<UserQuizResult> getAllUserQuizResults() {
        return userQuizResultService.getAllUserQuizResults();
    }

    @GetMapping("/{achievementId}/{tutorId}")
    public ResponseEntity<UserQuizResult> getUserQuizResultByIds(@PathVariable String achievementId, @PathVariable String tutorId) {
        Optional<UserQuizResult> userQuizResult = userQuizResultService.getUserQuizResultByIds(achievementId, tutorId);
        return userQuizResult.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create")
    public UserQuizResult createUserQuizResult(@RequestBody UserQuizResult userQuizResult) {
        return userQuizResultService.createUserQuizResult(userQuizResult);
    }

    @PutMapping("/update")
    public UserQuizResult updateUserQuizResult(@RequestBody UserQuizResult userQuizResult) {
        return userQuizResultService.updateUserQuizResult(userQuizResult);
    }

    @DeleteMapping("/delete/{achievementId}/{tutorId}")
    public ResponseEntity<Void> deleteUserQuizResult(@PathVariable String achievementId, @PathVariable String tutorId) {
        userQuizResultService.deleteUserQuizResult(achievementId, tutorId);
        return ResponseEntity.noContent().build();
    }
}