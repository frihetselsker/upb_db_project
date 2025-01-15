package com.langlearning.crud.controller;

import com.langlearning.crud.entity.assessment.UserQuizResult;
import com.langlearning.crud.service.UserQuizResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user-quiz-result")
@RequiredArgsConstructor
public class UserQuizResultController {
    @Autowired
    private UserQuizResultService userQuizResultService;

    @GetMapping("/all")
    public ResponseEntity<List<UserQuizResult>> getAllUserQuizResults() {
        return userQuizResultService.getAllUserQuizResults();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserQuizResult> getUserQuizResultById(@PathVariable int id) {
        return userQuizResultService.getUserQuizResultById(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserQuizResult>> getUserQuizResultsByUserId(@PathVariable int userId) {
        return userQuizResultService.getUserQuizResultsByUserId(userId);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<UserQuizResult>> getUserQuizResultsByQuizId(@PathVariable int quizId) {
        return userQuizResultService.getUserQuizResultsByQuizId(quizId);
    }

    @PostMapping("/create")
    public ResponseEntity<UserQuizResult> createUserQuizResult(@RequestBody UserQuizResult userQuizResult) {
        return userQuizResultService.createUserQuizResult(userQuizResult);
    }

    @PostMapping("/update")
    public ResponseEntity<UserQuizResult> updateUserQuizResult(@RequestBody UserQuizResult userQuizResult) {
        return userQuizResultService.updateUserQuizResult(userQuizResult);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserQuizResult(@PathVariable int id) {
        return userQuizResultService.deleteUserQuizResult(id);
    }
}