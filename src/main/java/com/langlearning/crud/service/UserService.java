package com.langlearning.crud.service;

import com.langlearning.crud.entity.user.LanguageProficiency;
import com.langlearning.crud.entity.user.User;
import com.langlearning.crud.entity.user.UserProfile;
import com.langlearning.crud.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

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
            if(existingUserProfile != null) {
                BeanUtils.copyProperties(userProfile, existingUserProfile, getNullPropertyNames(userProfile));
            } else {
                existingUserProfile = userProfile;
            }
            if (existingUserProfile.getProfileId() == 0) { // Complete checking with the actual object from DB
                existingUserProfile.setProfileId(sequenceGeneratorService.generateSequence("user_profile_sequence"));
            }
            if(userProfile.getLanguageProficiency() != null) {
                existingUser.getUserProfile().setLanguageProficiency(existingUserProfile.getLanguageProficiency());
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
            LanguageProficiency existingLanguageProficiency = existingUserProfile.getLanguageProficiency();
            if (existingLanguageProficiency != null) {
                BeanUtils.copyProperties(languageProficiency, existingLanguageProficiency, getNullPropertyNames(languageProficiency));
            } else {
                existingLanguageProficiency = languageProficiency;
            }
            if (existingLanguageProficiency.getProficiencyId() == 0) { // Complete checking with the actual object from DB
                existingLanguageProficiency.setProficiencyId(sequenceGeneratorService.generateSequence("language_proficiency_sequence"));
            }
            existingUserProfile.setLanguageProficiency(existingLanguageProficiency);
            existingUser.setUserProfile(existingUserProfile);
            userRepository.save(existingUser);
            return ResponseEntity.ok(existingUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }




}
