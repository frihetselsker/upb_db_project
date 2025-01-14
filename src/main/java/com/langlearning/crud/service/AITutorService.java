package com.langlearning.crud.service;

import com.langlearning.crud.entity.ai.AITutor;
import com.langlearning.crud.repository.ai.AITutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.BeanUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AITutorService {
    @Autowired
    private AITutorRepository aITutorRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<AITutor>> getAllAITutors() {
        return ResponseEntity.ok(aITutorRepository.findAll());
    }

    public ResponseEntity<AITutor> createEntity(AITutor entity) {
        entity.setTutorId(sequenceGeneratorService.generateSequence("ai_tutor_sequence"));
        aITutorRepository.save(entity);
        return ResponseEntity.ok(entity);
    }

    public ResponseEntity<Void> deleteEntity(int tutorId) {
        Optional<AITutor> aITutor = Optional.ofNullable(aITutorRepository.findByTutorId(tutorId));
        if (aITutor.isPresent()) {
            aITutorRepository.deleteByTutorId(tutorId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<AITutor> updateEntity(AITutor entity) {
        Optional<AITutor> aITutorOptional = Optional.ofNullable(aITutorRepository.findByTutorId(entity.getTutorId()));
        if (aITutorOptional.isPresent()) {
            AITutor existingAITutor = aITutorOptional.get();
            BeanUtils.copyProperties(entity, existingAITutor, getNullPropertyNames(entity));
            aITutorRepository.save(existingAITutor);
            return ResponseEntity.ok(existingAITutor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
