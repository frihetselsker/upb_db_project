package com.langlearning.crud.service;

import com.langlearning.crud.entity.course.Course;
import com.langlearning.crud.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseRepository.findAll());
    }

    public ResponseEntity<Course> createCourse(Course course) {
        course.setCourseId(sequenceGeneratorService.generateSequence("course_sequence"));
        courseRepository.save(course);
        return ResponseEntity.ok(course);
    }

    public ResponseEntity<Void> deleteCourse(int courseId) {
        Optional<Course> course = Optional.ofNullable(courseRepository.findByCourseId(courseId));
        if (course.isPresent()) {
            courseRepository.deleteByCourseId(courseId);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public ResponseEntity<Course> updateCourse(Course course) {
        Optional<Course> courseOptional = Optional.ofNullable(courseRepository.findByCourseId(course.getCourseId()));
        if (courseOptional.isPresent()) {
            Course existingCourse = courseOptional.get();
            BeanUtils.copyProperties(course, existingCourse, getNullPropertyNames(course));
            courseRepository.save(existingCourse);
            return ResponseEntity.ok(existingCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}
