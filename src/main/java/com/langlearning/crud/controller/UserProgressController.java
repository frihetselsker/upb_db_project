package com.langlearning.crud.controller;

import com.langlearning.crud.service.UserProgressService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user-progress")
public class UserProgressController {
    @Autowired
    private UserProgressService userProgressService;


    @GetMapping("/all")
    public Object getAllUserProgress() {
        return userProgressService.getAllUserProgress();
    }
}
