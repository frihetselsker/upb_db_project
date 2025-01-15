package com.langlearning.crud.service;

import com.langlearning.crud.entity.quizzes.QuizQuestion;
import com.langlearning.crud.repository.quizzes.QuizQuestionRepository;
import com.langlearning.crud.repository.quizzes.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.langlearning.crud.utilities.CopyManager.getNullPropertyNames;

@Service
@RequiredArgsConstructor
public class QuizQuestionService {
    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    private QuizRepository quizRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<QuizQuestion>> getAllQuizQuestions() {
        return ResponseEntity.ok(quizQuestionRepository.findAll());
    }

    public ResponseEntity<QuizQuestion> getQuizQuestionById(int questionId) {
        QuizQuestion quizQuestion = quizQuestionRepository.findByQuestionId(questionId);
        if (quizQuestion != null) {
            return ResponseEntity.ok(quizQuestion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<QuizQuestion>> getQuizQuestionsByQuizId(int quizId) {
        if (quizQuestionRepository.findQuizQuestionsByQuizId(quizId) != null) {
            return ResponseEntity.ok(quizQuestionRepository.findQuizQuestionsByQuizId(quizId));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<QuizQuestion> createQuizQuestion(QuizQuestion quizQuestion) {
        quizQuestion.setQuestionId(sequenceGeneratorService.generateSequence("user_question_sequence"));
        if (quizQuestion.getQuizId() == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            if (quizRepository.findByQuizId(quizQuestion.getQuizId()) == null) {
                return ResponseEntity.badRequest().build();
            } else {
                quizQuestionRepository.save(quizQuestion);
                return ResponseEntity.ok(quizQuestion);
            }
        }
    }

    public ResponseEntity<QuizQuestion> updateQuizQuestion(QuizQuestion entity) {
        Optional<QuizQuestion> quizQuestionOptional = Optional.ofNullable(quizQuestionRepository.findByQuestionId(entity.getQuestionId()));
        if (quizQuestionOptional.isPresent()) {
            QuizQuestion existingQuizQuestion = quizQuestionOptional.get();
            BeanUtils.copyProperties(entity, existingQuizQuestion, getNullPropertyNames(entity));
            if (entity.getQuizId() != 0) {
                if (quizRepository.findByQuizId(entity.getQuizId()) == null) {
                    return ResponseEntity.badRequest().build();
                }
            }
            quizQuestionRepository.save(existingQuizQuestion);
            return ResponseEntity.ok(existingQuizQuestion);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Void> deleteQuizQuestion(int questionId) {
        if (quizQuestionRepository.findByQuestionId(questionId) != null) {
            quizQuestionRepository.deleteByQuestionId(questionId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
