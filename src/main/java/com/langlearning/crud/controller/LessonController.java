package com.langlearning.crud.controller;

import com.langlearning.crud.entity.course.Lesson;
import com.langlearning.crud.entity.course.LessonContent;
import com.langlearning.crud.service.LessonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lesson")
@RequiredArgsConstructor
public class LessonController {
    @Autowired
    private LessonService lessonService;

    @GetMapping("/all")
    public ResponseEntity<List<Lesson>> getAllLessons() {
        return lessonService.getAllLessons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable int id) {
        return lessonService.getLessonById(id);
    }

    @GetMapping("/module/{moduleId}")
    public ResponseEntity<List<Lesson>> getLessonsByModuleId(@PathVariable int moduleId) {
        return lessonService.getLessonsByModuleId(moduleId);
    }

    @PostMapping("/create")
    public ResponseEntity<Lesson> createLesson(@RequestBody Lesson lesson) {
        return lessonService.createLesson(lesson);
    }

    @PutMapping("/update")
    public ResponseEntity<Lesson> updateLesson(@RequestBody Lesson lesson) {
        return lessonService.updateLesson(lesson);
    }

    @PutMapping("/update-content/{id}")
    public ResponseEntity<Lesson> updateContent(@RequestBody LessonContent content, @PathVariable int id) {
        return lessonService.updateLessonContent(id, content);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable int id) {
        return lessonService.deleteLesson(id);
    }
}
