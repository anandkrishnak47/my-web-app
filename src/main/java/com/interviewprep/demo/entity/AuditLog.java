package com.interviewprep.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "audit_logs")
@Getter
@Setter
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;
    private String username;
    private LocalDateTime timestamp;

    public AuditLog() {}

    public AuditLog(String action, String username) {
        this.action = action;
        this.username = username;
        this.timestamp = LocalDateTime.now();
    }

}
