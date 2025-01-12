package com.langlearning.crud.controller;

import com.langlearning.crud.entity.ai.AIConversation;
import com.langlearning.crud.service.AIConversationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ai-conversation")
public class AIConversationController {
    @Autowired
    private AIConversationService aiConversationService;

    @GetMapping("/all")
    public List<AIConversation> getAllAIConversations() {
        return aiConversationService.getAllAIConversations();
    }
}
