package com.langlearning.crud.controller;

import com.langlearning.crud.entity.feedback.UserFeedback;
import com.langlearning.crud.service.UserFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-feedback")
@RequiredArgsConstructor
public class UserFeedbackController {
    @Autowired
    private final UserFeedbackService userFeedbackService;

    @GetMapping("/all")
    public ResponseEntity<List<UserFeedback>> getAllUserFeedback() {
        return userFeedbackService.getAllUserFeedback();
    }

    @GetMapping("/{achievementId}/{tutorId}")
    public ResponseEntity<UserFeedback> getUserFeedbackByIds(@PathVariable String achievementId, @PathVariable String tutorId) {
        return userFeedbackService.getUserFeedbackByIds(achievementId, tutorId);
    }

    @PostMapping("/create")
    public ResponseEntity<UserFeedback> createUserFeedback(@RequestBody UserFeedback userFeedback) {
        return userFeedbackService.createUserFeedback(userFeedback);
    }

    @PutMapping("/update")
    public ResponseEntity<UserFeedback> updateUserFeedback(@RequestBody UserFeedback userFeedback) {
        return userFeedbackService.updateUserFeedback(userFeedback);
    }

    @DeleteMapping("/delete/{achievementId}/{tutorId}")
    public ResponseEntity<Void> deleteUserFeedback(@PathVariable String achievementId, @PathVariable String tutorId) {
        return userFeedbackService.deleteUserFeedback(achievementId, tutorId);
    }
}