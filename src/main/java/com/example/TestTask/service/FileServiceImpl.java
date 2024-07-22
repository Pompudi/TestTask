package com.example.TestTask.service;

import com.example.TestTask.model.File;
import com.example.TestTask.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepository fileRepository;

    @Override
    public Long createFile(String title, String description, LocalDateTime creationDate, String content){
        File file = new File();
        file.setTitle(title);
        file.setDescription(description);
        file.setContent(content);
        file.setCreationDate(creationDate);
        return fileRepository.save(file).getFileId();
    }

    @Override
    public File getFileById(Long id){
        return fileRepository.findById(id).orElseThrow(() -> new RuntimeException("File not found"));
    }

    @Override
    public List<File> getAllFilesSortedByCreationDate() {
        return fileRepository.findAllOrderByCreationDate();
    }
}
