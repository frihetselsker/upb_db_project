package com.langlearning.crud.controller;

import com.langlearning.crud.entity.feedback.UserFeedback;
import com.langlearning.crud.service.UserFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-feedback")
public class UserFeedbackController {
    @Autowired
    private UserFeedbackService userFeedbackService;

    @GetMapping("/all")
    public ResponseEntity<List<UserFeedback>> getAllUserFeedback() {
        return userFeedbackService.getAllUserFeedback();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserFeedback> getEntityById(@PathVariable int id) {
        return userFeedbackService.getEntityById(id);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserFeedback>> getFeedbackByUserId(@PathVariable int userId) {
        return userFeedbackService.getAllUserFeedbackByUserId(userId);
    }

    @PostMapping("/create")
    public ResponseEntity<UserFeedback> createEntity(@RequestBody UserFeedback entity) {
        return userFeedbackService.createEntity(entity);
    }

    @PostMapping("/update")
    public ResponseEntity<UserFeedback> updateEntity(@RequestBody UserFeedback entity) {
        return userFeedbackService.updateEntity(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable int id) {
        return userFeedbackService.deleteEntity(id);
    }
}
