package com.langlearning.crud.service;

import com.langlearning.crud.repository.assessment.UserProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserProgressService {
    @Autowired
    private UserProgressRepository userProgressRepository;

    public Object getAllUserProgress() {
        return userProgressRepository.findAll();
    }
}
