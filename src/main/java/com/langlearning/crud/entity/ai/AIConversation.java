package com.langlearning.crud.entity.ai;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Data
@Document(collection = "AIConversations")
public class AIConversation {
    @Id
    private String id;
    private int conversationId;
    private int userId;
    private int tutorId;
    private String languageCode;
    private Date startTime;
    private Date endTime;
    private String conversationContext;
}
