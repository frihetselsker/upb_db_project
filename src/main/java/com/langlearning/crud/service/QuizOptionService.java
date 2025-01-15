package com.langlearning.crud.service;

import com.langlearning.crud.entity.quizzes.QuizOption;
import com.langlearning.crud.entity.quizzes.QuizQuestion;
import com.langlearning.crud.repository.quizzes.QuizOptionRepository;
import com.langlearning.crud.repository.quizzes.QuizQuestionRepository;
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
public class QuizOptionService {
    @Autowired
    private QuizOptionRepository quizOptionRepository;

    @Autowired
    private QuizQuestionRepository quizQuestionRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<QuizOption>> getAllQuizOptions() {
        return ResponseEntity.ok(quizOptionRepository.findAll());
    }

    public ResponseEntity<QuizOption> getQuizOptionById(int optionId) {
        QuizOption quizOption = quizOptionRepository.findByOptionId(optionId);
        if (quizOption != null) {
            return ResponseEntity.ok(quizOption);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<List<QuizOption>> getQuizOptionsByQuestionId(int questionId) {
        if (quizQuestionRepository.findByQuestionId(questionId) == null) {
            return ResponseEntity.badRequest().build();
        } else {
            return ResponseEntity.ok(quizOptionRepository.findQuizOptionsByQuestionId(questionId));
        }
    }

    public ResponseEntity<QuizOption> createQuizOption(QuizOption quizOption) {
        quizOption.setOptionId(sequenceGeneratorService.generateSequence("quiz_option_sequence"));
        if (quizOption.getQuestionId() == 0) {
            return ResponseEntity.badRequest().build();
        } else {
            if (quizQuestionRepository.findByQuestionId(quizOption.getQuestionId()) == null) {
                return ResponseEntity.badRequest().build();
            } else {
                quizOptionRepository.save(quizOption);
                return ResponseEntity.ok(quizOption);
            }
        }
    }

    public ResponseEntity<Void> deleteQuizOption(int optionId) {
        if (quizOptionRepository.findByOptionId(optionId) != null) {
            quizOptionRepository.deleteByOptionId(optionId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<QuizOption> updateQuizOption(QuizOption entity) {
        Optional<QuizOption> quizOptionOptional = Optional.ofNullable(quizOptionRepository.findByOptionId(entity.getOptionId()));
        if (quizOptionOptional.isPresent()) {
            QuizOption existingQuizOption = quizOptionOptional.get();
            BeanUtils.copyProperties(entity, existingQuizOption, getNullPropertyNames(entity));
            if (entity.getQuestionId() != 0) {
                if (quizQuestionRepository.findByQuestionId(entity.getQuestionId()) == null) {
                    return ResponseEntity.badRequest().build();
                }
            }
            quizOptionRepository.save(existingQuizOption);
            return ResponseEntity.ok(existingQuizOption);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
