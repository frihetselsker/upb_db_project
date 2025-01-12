package com.langlearning.crud.service;

import com.langlearning.crud.repository.feedback.UserFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserFeedbackService {
    @Autowired
    private UserFeedbackRepository userFeedbackRepository;

    public Object getAllUserFeedback() {
        return userFeedbackRepository.findAll();
    }
}
