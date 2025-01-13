package com.langlearning.crud.entity.course;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Lesson {
    private int lessonId;
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
}
