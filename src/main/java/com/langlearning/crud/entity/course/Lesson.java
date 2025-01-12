package com.langlearning.crud.entity.course;

import lombok.Data;

@Data
public class Lesson {
    private int lessonId;
    private String title;
    private String lessonType;
    private int estimatedDuration;
    private LessonContent lessonContent;
}
