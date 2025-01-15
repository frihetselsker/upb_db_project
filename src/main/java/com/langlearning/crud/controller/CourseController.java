package com.langlearning.crud.controller;

import com.langlearning.crud.entity.course.Course;
import com.langlearning.crud.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Course>> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> getEntityById(@PathVariable int id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/create")
    public ResponseEntity<Course> createEntity(@RequestBody Course entity) {
        return courseService.createCourse(entity);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteEntity(@PathVariable int id) {
        return courseService.deleteCourse(id);
    }

    @PostMapping("/update")
    public ResponseEntity<Course> updateEntity(@RequestBody Course entity) {
        return courseService.updateCourse(entity);
    }
}
