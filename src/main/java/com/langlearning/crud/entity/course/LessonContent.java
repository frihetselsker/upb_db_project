package com.langlearning.crud.entity.course;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class LessonContent {
    private int contentId;
    private String contentType;
    private String contentBody;
    private String mediaUrl;

    public int getContentId() {
        return contentId;
    }

    public void setContentId(int contentId) {
        this.contentId = contentId;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentBody() {
        return contentBody;
    }

    public void setContentBody(String contentBody) {
        this.contentBody = contentBody;
    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }
}
