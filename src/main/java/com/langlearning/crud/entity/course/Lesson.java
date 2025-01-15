package com.langlearning.crud.entity.course;


import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@RequiredArgsConstructor
@Document(collection = "Lessons")
public class Lesson {
    @Id
    private String id;
    private int lessonId;
    private int moduleId;
    private String title;
    private String lessonType;
    private int estimatedDuration;
    private LessonContent lessonContent;

    public int getLessonId() {
        return lessonId;
    }

    public void setLessonId(int lessonId) {
        this.lessonId = lessonId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLessonType() {
        return lessonType;
    }

    public void setLessonType(String lessonType) {
        this.lessonType = lessonType;
    }

    public int getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(int estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public LessonContent getLessonContent() {
        return lessonContent;
    }

    public void setLessonContent(LessonContent lessonContent) {
        this.lessonContent = lessonContent;
    }

    public int getModuleId() {
        return moduleId;
    }

    public void setModuleId(int moduleId) {
        this.moduleId = moduleId;
    }
}
