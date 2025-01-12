package com.langlearning.crud.service;


import com.langlearning.crud.repository.quizzes.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QuizService {
    @Autowired
    private QuizRepository quizRepository;

    public Object getAllQuizzes() {
        return quizRepository.findAll();
    }
}
