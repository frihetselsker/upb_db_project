package com.langlearning.crud.service;

import com.langlearning.crud.entity.ai.AITutor;
import com.langlearning.crud.repository.ai.AITutorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AITutorService {
    @Autowired
    private AITutorRepository aITutorRepository;

    public List<AITutor> getAllAITutors() {
        return aITutorRepository.findAll();
    }
}
