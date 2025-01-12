package com.langlearning.crud.entity.user;

import lombok.Data;

import java.util.Date;

@Data
public class UserProfile {
    private int profileId;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String nativeLanguage;
    private LanguageProficiency languageProficiency;
    private String profilePictureUrl;
}
