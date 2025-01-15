package com.langlearning.crud.repository.assessment;

import com.langlearning.crud.entity.assessment.UserProgress;
import com.langlearning.crud.repository.user.UserRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserProgressRepository extends MongoRepository<UserProgress, String> {
    List<UserProgress> findUserProgressesByUserId(int userId);
    List<UserProgress> findUserProgressesByLessonId(int lessonId);
    UserProgress findUserProgressByProgressId(int progressId);
    void deleteByProgressId(int progressId);
}