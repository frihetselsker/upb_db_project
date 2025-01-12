package com.langlearning.crud.service;


import com.langlearning.crud.repository.assessment.UserQuizResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserQuizResultService {
    private UserQuizResultRepository userQuizResultRepository;

    public Object getAllUserQuizResults() {
        return userQuizResultRepository.findAll();
    }
}
