package com.example.TestTask.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class FileResponse {
    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("creationDate")
    private LocalDateTime creationDate;

    @JsonProperty("content")
    private String content;


    public FileResponse(String title, String description, LocalDateTime creationDate, String content) {
        this.title = title;
        this.description = description;
        this.creationDate = creationDate;
        this.content= content;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public String getContent() {
        return content;
    }
}
