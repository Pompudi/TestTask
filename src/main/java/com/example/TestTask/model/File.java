package com.example.TestTask.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Base64;


@Entity
@Table(name = "tb_file", schema = "public")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    @Column(name = "title", length = 255, nullable = false)
    private String title;

    @Column(name = "creation_date", nullable = false)
    private LocalDateTime creationDate;

    @Column(name = "description")
    private String description;

    @Column(name = "content", nullable = false)
    private byte[] content;

    public File() {
    }

    public File(Long fileId, String title, LocalDateTime creationDate, String description, byte[] content) {
        this.fileId = fileId;
        this.title = title;
        this.creationDate = creationDate;
        this.description = description;
        this.content = Base64.getDecoder().decode(content);
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return Base64.getEncoder().encodeToString(this.content);
    }

    public void setContent(String content){
        this.content = Base64.getDecoder().decode(content);
    }
}
