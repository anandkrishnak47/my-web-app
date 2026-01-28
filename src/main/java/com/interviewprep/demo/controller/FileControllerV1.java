package com.interviewprep.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/files")
public class FileControllerV1 {

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFileV1(@RequestParam MultipartFile file) {
        return ResponseEntity.ok("File uploaded (v1): " + file.getOriginalFilename());
    }

}
