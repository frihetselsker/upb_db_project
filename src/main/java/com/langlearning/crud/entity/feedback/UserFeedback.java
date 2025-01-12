package com.langlearning.crud.entity.feedback;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "UserFeedbacks")
public class UserFeedback {
    @Id
    private String id;
    private int feedbackId;
    private int userId;
    private String feedbackType;
    private int referenceId;
    private int rating;
    private String comments;
    private Date submittedAt;
}
