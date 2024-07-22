package com.example.TestTask.controller;


import com.example.TestTask.controller.dto.FileRequest;
import com.example.TestTask.controller.dto.FileResponse;
import com.example.TestTask.model.File;
import com.example.TestTask.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/files")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping
    public ResponseEntity<Long> createFile(@RequestBody FileRequest fileRequest) {
        Long fileId = fileService.createFile(
                fileRequest.getTitle(),
                fileRequest.getDescription(),
                fileRequest.getCreationDate(),
                fileRequest.getContent());
        return new ResponseEntity<>(fileId, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FileResponse> getFileById(@PathVariable Long id){
        File file = fileService.getFileById(id);
        FileResponse fileResponse = new FileResponse(
                file.getTitle(),
                file.getDescription(),
                file.getCreationDate(),
                file.getContent());
        return new ResponseEntity<>(fileResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<FileResponse>> getAllFiles() {
        List<FileResponse> fileResponses = fileService.getAllFilesSortedByCreationDate().stream()
                .map(file -> new FileResponse(
                        file.getTitle(),
                        file.getDescription(),
                        file.getCreationDate(),
                        file.getContent()))
                .collect(Collectors.toList());
        return new ResponseEntity<>(fileResponses, HttpStatus.OK);
    }

}

