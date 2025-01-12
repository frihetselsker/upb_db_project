package com.langlearning.crud.entity.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "Users")
public class User {
    @Id
    private String id;
    private int userId;
    private String email;
    private String passwordHash;
    private Date registrationDate;
    private UserProfile userProfile;
    private boolean isActive;

}
