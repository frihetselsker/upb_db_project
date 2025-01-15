package com.langlearning.crud.service;

import com.langlearning.crud.entity.course.Course;
import com.langlearning.crud.repository.course.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.langlearning.crud.utilities.CopyManager.getNullPropertyNames;

@Service
@RequiredArgsConstructor
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private ModuleService moduleService;

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.ok(courseRepository.findAll());
    }

    public ResponseEntity<Course> getCourseById(int id){
        return ResponseEntity.ok(courseRepository.findByCourseId(id));
    }

    public ResponseEntity<Course> createCourse(Course course){
        course.setCourseId(sequenceGeneratorService.generateSequence("course_sequence"));
        courseRepository.save(course);
        return ResponseEntity.ok(course);
    }

    public ResponseEntity<Void> deleteCourse(int courseId){
        courseRepository.deleteByCourseId(courseId);
        moduleService.deleteModulesByCourseId(courseId);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Course> updateCourse(Course entity){
        Optional<Course> courseOptional = Optional.ofNullable(courseRepository.findByCourseId(entity.getCourseId()));
        if (courseOptional.isPresent()) {
            Course existingCourse = courseOptional.get();
            BeanUtils.copyProperties(entity, existingCourse, getNullPropertyNames(entity));
            courseRepository.save(existingCourse);
            return ResponseEntity.ok(existingCourse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
