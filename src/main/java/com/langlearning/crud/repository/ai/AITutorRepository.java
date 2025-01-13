package com.langlearning.crud.repository.ai;

import com.langlearning.crud.entity.ai.AITutor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AITutorRepository extends MongoRepository<AITutor, String> {
    AITutor findByTutorId(int tutorId);
    void deleteByTutorId(int tutorId);
}
