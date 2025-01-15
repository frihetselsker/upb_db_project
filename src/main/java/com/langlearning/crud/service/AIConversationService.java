package com.langlearning.crud.service;

import com.langlearning.crud.entity.ai.AIConversation;
import com.langlearning.crud.entity.ai.AITutor;
import com.langlearning.crud.repository.ai.AITutorRepository;
import com.langlearning.crud.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.langlearning.crud.repository.ai.AIConversationRepository;

import java.util.List;
import java.util.Optional;

import static com.langlearning.crud.utilities.CopyManager.getNullPropertyNames;

@Service
@RequiredArgsConstructor
public class AIConversationService {
    @Autowired
    private AIConversationRepository aiConversationRepository;

    @Autowired
    private AITutorRepository aiTutorRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;


    public ResponseEntity<List<AIConversation>> getAllAIConversations() {
        return ResponseEntity.ok().body(aiConversationRepository.findAll());
    }

    public ResponseEntity<AIConversation> getAIConversationById(int id) {
        return ResponseEntity.ok().body(aiConversationRepository.findByConversationId(id));
    }

    public ResponseEntity<AIConversation> createEntity(AIConversation entity) {
        entity.setConversationId(sequenceGeneratorService.generateSequence("ai_conversation_sequence"));
        if (entity.getTutorId() != 0) {
            if (aiTutorRepository.findByTutorId(entity.getTutorId()) == null) {
                return ResponseEntity.badRequest().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
        if (entity.getUserId() != 0) {
            if (userRepository.findByUserId(entity.getUserId()) == null) {
                return ResponseEntity.badRequest().build();
            } else {
                aiConversationRepository.save(entity);
                return ResponseEntity.ok().body(entity);
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    public ResponseEntity<Void> deleteEntity(int conversationId) {
        aiConversationRepository.deleteByConversationId(conversationId);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<AIConversation> updateEntity(AIConversation entity) {
        Optional<AIConversation> aiConversationOptional = Optional.ofNullable(aiConversationRepository.findByConversationId(entity.getTutorId()));
        if (aiConversationOptional.isPresent()) {
            AIConversation existingAIConversation = aiConversationOptional.get();
            BeanUtils.copyProperties(entity, existingAIConversation, getNullPropertyNames(entity));
            if (entity.getTutorId() != 0) {
                if (aiTutorRepository.findByTutorId(entity.getTutorId()) == null) {
                    return ResponseEntity.badRequest().build();
                }
            } else {
                return ResponseEntity.badRequest().build();
            }
            if (entity.getUserId() != 0) {
                if (userRepository.findByUserId(entity.getUserId()) == null) {
                    return ResponseEntity.badRequest().build();
                } else {
                    aiConversationRepository.save(existingAIConversation);
                    return ResponseEntity.ok().body(existingAIConversation);
                }
            } else {
                return ResponseEntity.badRequest().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
