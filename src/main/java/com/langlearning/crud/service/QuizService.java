package com.langlearning.crud.service;

import com.langlearning.crud.entity.quizzes.Quiz;
import com.langlearning.crud.repository.quizzes.QuizRepository;
import com.langlearning.crud.repository.user.UserRepository;
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
    private QuizRepository quizRepository;

    /*@Autowired
    private QuizQuestionService quizQuestionService;

    @Autowired
    private QuizOptionService quizOptionService;*/

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<Quiz>> getAllQuizzes() {
        return ResponseEntity.ok(quizRepository.findAll());
    }

    public ResponseEntity<Quiz> getQuizById(int id) {
        if (quizRepository.findByQuizId(id) != null) {
            return ResponseEntity.ok(quizRepository.findByQuizId(id));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Quiz> createQuiz(Quiz quiz) {
        quiz.setQuizId(sequenceGeneratorService.generateSequence("quiz_sequence"));
        quizRepository.save(quiz);
        return ResponseEntity.ok(quiz);
    }

    public ResponseEntity<Quiz> updateQuiz(Quiz quiz) {
        return ResponseEntity.ok(quizRepository.save(quiz));
    }

    public ResponseEntity<Void> deleteQuiz(int id){
        if (quizRepository.findByQuizId(id) != null) {
            quizRepository.deleteByQuizId(id);
            //quizQuestionService.deleteQuestionsByQuizId(id);
            //quizOptionService.deleteOptionsByQuizId(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}