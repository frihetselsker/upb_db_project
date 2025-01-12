package com.langlearning.crud.controller;

import com.langlearning.crud.service.UserFeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-feedback")
public class UserFeedbackController {
    @Autowired
    private UserFeedbackService userFeedbackService;


    @GetMapping("/all")
    public Object getAllUserFeedback() {
        return userFeedbackService.getAllUserFeedback();
    }
}
