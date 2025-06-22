package com.langlearning.crud.controller;

import com.langlearning.crud.entity.quizzes.QuizQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.langlearning.crud.service.QuizQuestionService;

import java.util.List;

@RestController
@RequestMapping("/api/quiz-question")
public class QuizQuestionController {
    @Autowired
    private QuizQuestionService quizQuestionService;

    @GetMapping("/all")
    public ResponseEntity<List<QuizQuestion>> getAllQuizQuestions() {
        return quizQuestionService.getAllQuizQuestions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizQuestion> getQuizQuestionById(@PathVariable int id) {
        return quizQuestionService.getQuizQuestionById(id);
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<QuizQuestion>> getQuizQuestionsByQuizId(@PathVariable int quizId) {
        return quizQuestionService.getQuizQuestionsByQuizId(quizId);
    }

    @PostMapping("/create")
    public ResponseEntity<QuizQuestion> createQuizQuestion(@RequestBody QuizQuestion quizQuestion) {
        return quizQuestionService.createQuizQuestion(quizQuestion);
    }

    @PutMapping("/update")
    public ResponseEntity<QuizQuestion> updateQuizQuestion(@RequestBody QuizQuestion quizQuestion) {
        return quizQuestionService.updateQuizQuestion(quizQuestion);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuizQuestion(@PathVariable int id) {
        return quizQuestionService.deleteQuizQuestion(id);
    }
}
