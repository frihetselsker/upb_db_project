package com.langlearning.crud.controller;

import com.langlearning.crud.service.ModuleService;
import com.langlearning.crud.entity.course.Module;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/module")
@RequiredArgsConstructor
public class ModuleController {
    @Autowired
    private ModuleService moduleService;

    @GetMapping("/all")
    public ResponseEntity<List<Module>> getAllModules() {
        return moduleService.getAllModules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Module> getModuleById(@PathVariable int id) {
        return moduleService.getModuleById(id);
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Module>> getModulesByCourseId(@PathVariable int courseId) {
        return moduleService.getModulesByCourseId(courseId);
    }

    @PostMapping("/create")
    public ResponseEntity<Module> createModule(@RequestBody Module module) {
        return moduleService.createModule(module);
    }

    @PostMapping("/update")
    public ResponseEntity<Module> updateModule(@RequestBody Module module) {
        return moduleService.updateModule(module);
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable int id) {
        return moduleService.deleteModule(id);
    }
}
