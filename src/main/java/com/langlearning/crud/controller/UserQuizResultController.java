package com.langlearning.crud.controller;

import com.langlearning.crud.service.UserQuizResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-quiz-result")
public class UserQuizResultController {
    @Autowired
    private UserQuizResultService userQuizResultService;


    @GetMapping("/all")
    public Object getAllUserQuizResults() {
        return userQuizResultService.getAllUserQuizResults();
    }
}
