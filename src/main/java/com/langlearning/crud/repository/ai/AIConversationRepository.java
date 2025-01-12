package com.langlearning.crud.repository.ai;

import com.langlearning.crud.entity.ai.AIConversation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AIConversationRepository extends MongoRepository<AIConversation, String> {
}
