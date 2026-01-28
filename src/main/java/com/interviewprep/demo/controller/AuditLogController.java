package com.interviewprep.demo.controller;

import com.interviewprep.demo.entity.AuditLog;
import com.interviewprep.demo.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditLogController {

    @Autowired
    private AuditLogRepository auditLogRepository;

    // Fetch all audit logs
    @GetMapping
    public ResponseEntity<List<AuditLog>> getAllLogs() {
        List<AuditLog> logs = auditLogRepository.findAll();
        return ResponseEntity.ok(logs);
    }

    // Fetch logs by username
    @GetMapping("/{username}")
    public ResponseEntity<List<AuditLog>> getLogsByUser(@PathVariable String username) {
        List<AuditLog> logs = auditLogRepository.findByUsername(username);
        return ResponseEntity.ok(logs);
    }

}
