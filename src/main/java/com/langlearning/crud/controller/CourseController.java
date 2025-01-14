package com.langlearning.crud.controller;

import com.langlearning.crud.entity.course.Course;
import com.langlearning.crud.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/create")
    public ResponseEntity<Course> createCourse(@RequestBody Course entity) {
        return courseService.createCourse(entity);
    }

    @GetMapping("/update")
    public ResponseEntity<Course> updateCourse(@RequestBody Course entity) {
        return courseService.updateCourse(entity);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }
}
