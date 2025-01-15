package com.langlearning.crud.repository.course;

import com.langlearning.crud.entity.course.Lesson;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LessonRepository extends MongoRepository<Lesson, String> {
    Lesson findByLessonId(int lessonId);
    List<Lesson> findByModuleId(int moduleId);
    void deleteLessonsByModuleId(int moduleId);
    void deleteByLessonId(int lessonId);

}
