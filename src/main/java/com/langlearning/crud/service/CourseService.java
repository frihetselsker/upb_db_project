package com.langlearning.crud.service;

import com.langlearning.crud.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public Object getAllCourses() {
        return courseRepository.findAll();
    }
}
