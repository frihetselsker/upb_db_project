package com.langlearning.crud.repository.user;

import com.langlearning.crud.entity.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByEmail(String email);
    Optional<User> findByUserId(int userId);
    List<User> findByIsActive(boolean isActive);
    List<User> findByRegistrationDate(String registrationDate);
    List<User> findByUserProfileFirstName(String firstName);
    List<User> findByUserProfileLastName(String lastName);
    List<User> findByUserProfileBirthDate(String birthDate);
    List<User> findByUserProfileNativeLanguage(String nativeLanguage);

}
