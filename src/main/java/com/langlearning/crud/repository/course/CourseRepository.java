package com.langlearning.crud.repository.course;

import com.langlearning.crud.entity.course.Course;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends MongoRepository<Course, String> {

}
