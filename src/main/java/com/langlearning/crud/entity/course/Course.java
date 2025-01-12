package com.langlearning.crud.entity.course;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Data
@Document(collection = "Courses")
public class Course {
    @Id
    private String id;
    private int courseId;
    private String title;
    private String description;
    private String languageCode;
    private String difficultyLevel;
    private double price;
    private boolean isPublished;
    private ArrayList<Module> modules;
}
