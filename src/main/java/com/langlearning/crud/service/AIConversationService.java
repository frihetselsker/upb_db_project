package com.langlearning.crud.service;

import com.langlearning.crud.entity.ai.AIConversation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.langlearning.crud.repository.ai.AIConversationRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AIConversationService {
    @Autowired
    private AIConversationRepository aiConversationRepository;

    public List<AIConversation> getAllAIConversations() {
        return aiConversationRepository.findAll();
    }
}
