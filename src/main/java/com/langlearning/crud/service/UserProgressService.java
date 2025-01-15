package com.langlearning.crud.service;

import com.langlearning.crud.entity.assessment.UserProgress;
import com.langlearning.crud.repository.assessment.UserProgressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserProgressService {
    @Autowired
    private final UserProgressRepository userProgressRepository;

    public List<UserProgress> getAllUserProgress() {
        return userProgressRepository.findAll();
    }

    public Optional<UserProgress> getUserProgressByIds(String achievementId, String tutorId) {
        return userProgressRepository.findByAchievementIdAndTutorId(achievementId, tutorId);
    }

    public UserProgress createUserProgress(UserProgress userProgress) {
        return userProgressRepository.save(userProgress);
    }

    public UserProgress updateUserProgress(UserProgress userProgress) {
        return userProgressRepository.save(userProgress);
    }

    public void deleteUserProgress(String achievementId, String tutorId) {
        userProgressRepository.deleteByAchievementIdAndTutorId(achievementId, tutorId);
    }
}