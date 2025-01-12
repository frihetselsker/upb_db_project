package com.langlearning.crud.entity.course;

import lombok.Data;

@Data
public class LessonContent {
    private int contentId;
    private String contentType;
    private String contentBody;
    private String mediaUrl;
}
