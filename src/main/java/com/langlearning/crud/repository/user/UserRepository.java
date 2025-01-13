package com.langlearning.crud.repository.user;

import com.langlearning.crud.entity.user.LanguageProficiency;
import com.langlearning.crud.entity.user.User;
import com.langlearning.crud.entity.user.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByEmail(String email);
    User findByUserId(int userId);
    UserProfile findByUserProfile_ProfileId(int profileId);

    LanguageProficiency findByUserProfile_LanguageProficiency_ProficiencyId(int proficiencyId);
    List<User> findByIsActive(boolean isActive);
    List<User> findByRegistrationDate(String registrationDate);
    List<User> findByUserProfileFirstName(String firstName);
    List<User> findByUserProfileLastName(String lastName);
    List<User> findByUserProfileBirthDate(String birthDate);
    List<User> findByUserProfileNativeLanguage(String nativeLanguage);

    void deleteByUserId(int userId);
}

