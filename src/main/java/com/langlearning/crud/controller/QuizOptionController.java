package com.langlearning.crud.controller;

import com.langlearning.crud.entity.quizzes.QuizOption;
import com.langlearning.crud.service.QuizOptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quiz-option")
@RequiredArgsConstructor
public class QuizOptionController {
    @Autowired
    private QuizOptionService quizOptionService;

    @GetMapping("/all")
    public ResponseEntity<List<QuizOption>> getAllQuizOptions() {
        return quizOptionService.getAllQuizOptions();
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizOption> getQuizOptionById(@PathVariable int id) {
        return quizOptionService.getQuizOptionById(id);
    }

    @GetMapping("/question/{questionId}")
    public ResponseEntity<List<QuizOption>> getQuizOptionsByQuestionId(@PathVariable int questionId) {
        return quizOptionService.getQuizOptionsByQuestionId(questionId);
    }

    @PostMapping("/create")
    public ResponseEntity<QuizOption> createQuizOption(@RequestBody QuizOption quizOption) {
        return quizOptionService.createQuizOption(quizOption);
    }

    @PostMapping("/update")
    public ResponseEntity<QuizOption> updateQuizOption(@RequestBody QuizOption quizOption) {
        return quizOptionService.updateQuizOption(quizOption);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuizOption(@PathVariable int id) {
        return quizOptionService.deleteQuizOption(id);
    }
}
