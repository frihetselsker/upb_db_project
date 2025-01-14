package com.langlearning.crud.service;

import com.langlearning.crud.entity.ai.AIConversation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.langlearning.crud.repository.ai.AIConversationRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AIConversationService {
    @Autowired
    private AIConversationRepository aiConversationRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<AIConversation>> getAllAIConversations() {
        return ResponseEntity.ok(aiConversationRepository.findAll());
    }

    public ResponseEntity<AIConversation> createEntity(AIConversation entity) {
        entity.setConversationId(sequenceGeneratorService.generateSequence("ai_conversation_sequence"));
        aiConversationRepository.save(entity);
        return ResponseEntity.ok(entity);
    }

    public ResponseEntity<Void> deleteEntity(int conversationId) {
        Optional<AIConversation> aiConversation = Optional.ofNullable(aiConversationRepository.findByConversationId(conversationId));
        if (aiConversation.isPresent()) {
            aiConversationRepository.deleteByConversationId(conversationId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<AIConversation> updateEntity(AIConversation entity) {
        Optional<AIConversation> aiConversationOptional = Optional.ofNullable(aiConversationRepository.findByConversationId(entity.getConversationId()));
        if (aiConversationOptional.isPresent()) {
            AIConversation existingAIConversation = aiConversationOptional.get();
            BeanUtils.copyProperties(entity, existingAIConversation, getNullPropertyNames(entity));
            aiConversationRepository.save(existingAIConversation);
            return ResponseEntity.ok(existingAIConversation);
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
