package com.langlearning.crud.entity.course;

import lombok.Data;

import java.util.List;

@Data
public class Module {
    private int moduleId;
    private String title;
    private String description;
    private int orderSequence;
    private List<Lesson> lessons;
}
