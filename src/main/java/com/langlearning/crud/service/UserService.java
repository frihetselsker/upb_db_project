package com.langlearning.crud.service;

import com.langlearning.crud.entity.user.LanguageProficiency;
import com.langlearning.crud.entity.user.User;
import com.langlearning.crud.entity.user.UserProfile;
import com.langlearning.crud.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.langlearning.crud.utilities.CopyManager.getNullPropertyNames;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    public ResponseEntity<User> getUserById(int id) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUserId(id));
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<User> createUser(User user) {
        user.setUserId(sequenceGeneratorService.generateSequence("user_sequence"));
        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    public ResponseEntity<Void> deleteUser(int userId) {
        Optional<User> user = Optional.ofNullable(userRepository.findByUserId(userId));
        if (user.isPresent()) {
            userRepository.deleteByUserId(userId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> updateEntity(User entity) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUserId(entity.getUserId()));
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            BeanUtils.copyProperties(entity, existingUser, getNullPropertyNames(entity));
            userRepository.save(existingUser);
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<User> updateProfile(int userId, UserProfile userProfile) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUserId(userId));
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            UserProfile existingUserProfile = existingUser.getUserProfile();

            if (existingUserProfile == null) {
                existingUserProfile = new UserProfile();
                existingUser.setUserProfile(existingUserProfile);
            }
            int existingProfileId = existingUserProfile.getProfileId();
            BeanUtils.copyProperties(userProfile, existingUserProfile, getNullPropertyNames(userProfile));
            if (existingProfileId != 0) {
                existingUserProfile.setProfileId(existingProfileId);
            } else {
                existingUserProfile.setProfileId(sequenceGeneratorService.generateSequence("user_profile_sequence"));
            }
            if (userProfile.getLanguageProficiency() != null) {
                if (existingUserProfile.getLanguageProficiency() == null) {
                    existingUserProfile.setLanguageProficiency(new LanguageProficiency());
                }
                BeanUtils.copyProperties(
                        userProfile.getLanguageProficiency(),
                        existingUserProfile.getLanguageProficiency(),
                        getNullPropertyNames(userProfile.getLanguageProficiency())
                );
            }

            existingUser.setUserProfile(existingUserProfile);
            userRepository.save(existingUser);
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    public ResponseEntity<User> updateLanguageProficiency(int userId, LanguageProficiency languageProficiency) {
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUserId(userId));
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            UserProfile existingUserProfile = existingUser.getUserProfile();
            if (existingUserProfile == null) {
                existingUserProfile = new UserProfile();
                existingUser.setUserProfile(existingUserProfile);
            }
            LanguageProficiency existingLanguageProficiency = existingUserProfile.getLanguageProficiency();
            if (existingLanguageProficiency == null) {
                existingLanguageProficiency = new LanguageProficiency();
                existingUserProfile.setLanguageProficiency(existingLanguageProficiency);
            }
            int existingProficiencyId = existingLanguageProficiency.getProficiencyId();
            BeanUtils.copyProperties(languageProficiency, existingLanguageProficiency, getNullPropertyNames(languageProficiency));
            if (existingProficiencyId != 0) {
                existingLanguageProficiency.setProficiencyId(existingProficiencyId);
            } else {
                existingLanguageProficiency.setProficiencyId(sequenceGeneratorService.generateSequence("language_proficiency_sequence"));
            }

            userRepository.save(existingUser);
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
