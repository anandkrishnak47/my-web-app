package com.interviewprep.demo.controller;

import com.interviewprep.demo.service.FileProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v2/files")
public class FileControllerV2 {

    @Autowired
    private FileProcessingService fileProcessingService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFileV2(@RequestParam MultipartFile file) {
        fileProcessingService.processFile(file);
        return ResponseEntity.accepted().body("File uploaded (v2). Processing async.");
    }

}
