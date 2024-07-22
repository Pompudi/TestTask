package com.example.TestTask.service;

import com.example.TestTask.model.File;

import java.time.LocalDateTime;
import java.util.List;

public interface FileService {
    Long createFile(String title, String description, LocalDateTime creationDate, String data);

    File getFileById(Long id);

    List<File> getAllFilesSortedByCreationDate();
}
