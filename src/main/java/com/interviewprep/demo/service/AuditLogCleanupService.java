package com.interviewprep.demo.service;

import com.interviewprep.demo.config.AuditProperties;
import com.interviewprep.demo.repository.AuditLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;

public class AuditLogCleanupService {

    // Inject value from application.properties
    @Value("${audit.retention.days}")
    private int retentionDays;

    @Autowired
    private AuditLogRepository auditLogRepository;

    @Autowired
    private AuditProperties auditProperties;

    @Scheduled(cron = "#{@auditProperties.cleanupCron}") // Runs daily at midnight
    public void cleanUpOldLogs() {
        LocalDateTime cutoff = LocalDateTime.now().minusDays(auditProperties.getRetentionDays());
        auditLogRepository.deleteByTimestampBefore(cutoff);
        System.out.println("Purged audit logs older than " + auditProperties.getRetentionDays() + " days at " + LocalDateTime.now());
    }

}
