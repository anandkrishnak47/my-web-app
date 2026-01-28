package com.interviewprep.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.CompletableFuture;

@Service
public class FileProcessingService {

    @Async
    public CompletableFuture<String> processFile(MultipartFile file) {
        try { Thread.sleep(5000); } catch (InterruptedException ignored) {}
        return CompletableFuture.completedFuture("Processed: " + file.getOriginalFilename());
    }

}
