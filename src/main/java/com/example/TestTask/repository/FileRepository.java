package com.example.TestTask.repository;


import com.example.TestTask.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileRepository extends JpaRepository <File, Long> {
    @Query(value = "SELECT f FROM File f ORDER BY f.creationDate DESC")
    List<File> findAllOrderByCreationDate();
}

