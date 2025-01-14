package com.langlearning.crud.service;

import com.langlearning.crud.entity.quizzes.Quiz;
import com.langlearning.crud.repository.quizzes.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {
    @Autowired
    private final QuizRepository quizRepository;

    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return ResponseEntity.ok(quizRepository.findAll());
    }

    public ResponseEntity<Quiz> getQuizById(String id) {
        Optional<Quiz> quiz = quizRepository.findById(id);
        return quiz.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Quiz> createQuiz(Quiz quiz) {
        return ResponseEntity.ok(quizRepository.save(quiz));
    }

    public ResponseEntity<Quiz> updateQuiz(Quiz quiz) {
        return ResponseEntity.ok(quizRepository.save(quiz));
    }

    public ResponseEntity<Void> deleteQuiz(String id) {
        quizRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}