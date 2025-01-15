package com.langlearning.crud.service;

import com.langlearning.crud.entity.course.Lesson;
import com.langlearning.crud.entity.course.LessonContent;
import com.langlearning.crud.entity.course.Module;
import com.langlearning.crud.entity.user.LanguageProficiency;
import com.langlearning.crud.entity.user.User;
import com.langlearning.crud.entity.user.UserProfile;
import com.langlearning.crud.repository.course.LessonRepository;
import com.langlearning.crud.repository.course.ModuleRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.langlearning.crud.utilities.CopyManager.getNullPropertyNames;

@Service
public class LessonService {
    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<Lesson>> getAllLessons(){
        return ResponseEntity.ok(lessonRepository.findAll());
    }

    public ResponseEntity<Lesson> getLessonById(int id){
        return ResponseEntity.ok(lessonRepository.findByLessonId(id));
    }

    public ResponseEntity<List<Lesson>> getLessonsByModuleId(int moduleId){
        return ResponseEntity.ok(lessonRepository.findByModuleId(moduleId));
    }

    public ResponseEntity<Lesson> createLesson(Lesson lesson){
        lesson.setLessonId(sequenceGeneratorService.generateSequence("lesson_sequence"));
        lessonRepository.save(lesson);
        return ResponseEntity.ok(lesson);
    }

    public ResponseEntity<Void> deleteLesson(int lessonId){
        lessonRepository.deleteByLessonId(lessonId);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> deleteLessonsByModuleId(int moduleId){
        lessonRepository.deleteLessonsByModuleId(moduleId);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Lesson> updateLesson(Lesson entity){
        Optional<Lesson> lessonOptional = Optional.ofNullable(lessonRepository.findByLessonId(entity.getModuleId()));
        if (lessonOptional.isPresent()) {
            Lesson existingLesson = lessonOptional.get();
            BeanUtils.copyProperties(entity, existingLesson, getNullPropertyNames(entity));
            if(moduleRepository.findByModuleId(existingLesson.getModuleId()) == null){
                return ResponseEntity.notFound().build();
            }
            lessonRepository.save(existingLesson);
            return ResponseEntity.ok(existingLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Lesson> updateLessonContent(int lessonId, LessonContent lessonContent) {
        Optional<Lesson> lessonOptional = Optional.ofNullable(lessonRepository.findByLessonId(lessonId));
        if (lessonOptional.isPresent()) {
            Lesson existingLesson = lessonOptional.get();
            LessonContent existingLessonContent = existingLesson.getLessonContent();

            if (existingLessonContent == null) {
                existingLessonContent = new LessonContent();
                existingLesson.setLessonContent(existingLessonContent);
            }
            int existingLessonContentId = existingLessonContent.getContentId();
            BeanUtils.copyProperties(lessonContent, existingLessonContent, getNullPropertyNames(lessonContent));
            if (existingLessonContentId != 0) {
                existingLessonContent.setContentId(existingLessonContentId);
            } else {
                existingLessonContent.setContentId(sequenceGeneratorService.generateSequence("lesson_content_sequence"));
            }
            existingLesson.setLessonContent(existingLessonContent);
            lessonRepository.save(existingLesson);
            return ResponseEntity.ok(existingLesson);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
