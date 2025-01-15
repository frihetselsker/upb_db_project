package com.langlearning.crud.service;

import com.langlearning.crud.entity.assessment.UserQuizResult;
import com.langlearning.crud.repository.assessment.UserQuizResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserQuizResultService {
    @Autowired
    private final UserQuizResultRepository userQuizResultRepository;

    public List<UserQuizResult> getAllUserQuizResults() {
        return userQuizResultRepository.findAll();
    }

    public Optional<UserQuizResult> getUserQuizResultByIds(String achievementId, String tutorId) {
        return userQuizResultRepository.findByAchievementIdAndTutorId(achievementId, tutorId);
    }

    public UserQuizResult createUserQuizResult(UserQuizResult userQuizResult) {
        return userQuizResultRepository.save(userQuizResult);
    }

    public UserQuizResult updateUserQuizResult(UserQuizResult userQuizResult) {
        return userQuizResultRepository.save(userQuizResult);
    }

    public void deleteUserQuizResult(String achievementId, String tutorId) {
        userQuizResultRepository.deleteByAchievementIdAndTutorId(achievementId, tutorId);
    }
}