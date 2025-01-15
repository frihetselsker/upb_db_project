package com.langlearning.crud.service;

import com.langlearning.crud.repository.course.CourseRepository;
import com.langlearning.crud.repository.course.ModuleRepository;
import com.langlearning.crud.entity.course.Module;
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
public class ModuleService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    /*@Autowired
    private LessonService lessonService;*/

    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;

    public ResponseEntity<List<Module>> getAllModules(){
        return ResponseEntity.ok(moduleRepository.findAll());
    }

    public ResponseEntity<Module> getModuleById(int id){
        return ResponseEntity.ok(moduleRepository.findByModuleId(id));
    }

    public ResponseEntity<List<Module>> getModulesByCourseId(int courseId){
        return ResponseEntity.ok(moduleRepository.findByCourseId(courseId));
    }

    public ResponseEntity<Module> createModule(Module module){
        module.setModuleId(sequenceGeneratorService.generateSequence("module_sequence"));
        moduleRepository.save(module);
        return ResponseEntity.ok(module);
    }

    public ResponseEntity<Void> deleteModule(int moduleId){
        moduleRepository.deleteByModuleId(moduleId);
        //lessonService.deleteLessonsByModuleId(moduleId);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Void> deleteModulesByCourseId(int courseId){
        moduleRepository.deleteModulesByCourseId(courseId);
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity<Module> updateModule(Module entity){
        Optional<Module> moduleOptional = Optional.ofNullable(moduleRepository.findByModuleId(entity.getModuleId()));
        if (moduleOptional.isPresent()) {
            Module existingModule = moduleOptional.get();
            BeanUtils.copyProperties(entity, existingModule, getNullPropertyNames(entity));
            if(courseRepository.findByCourseId(existingModule.getCourseId()) == null){
                return ResponseEntity.notFound().build();
            }
            moduleRepository.save(existingModule);
            return ResponseEntity.ok(existingModule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
