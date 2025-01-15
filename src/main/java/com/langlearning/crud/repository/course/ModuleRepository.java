package com.langlearning.crud.repository.course;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.langlearning.crud.entity.course.Module;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleRepository extends MongoRepository<Module, String> {
    Module findByModuleId(int moduleId);
    List<Module> findByCourseId(int courseId);

    void deleteByModuleId(int moduleId);
    void deleteModulesByCourseId(int courseId);
}
