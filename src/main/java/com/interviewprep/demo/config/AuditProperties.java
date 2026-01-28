package com.interviewprep.demo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "audit")
public class AuditProperties {
    /**
     * Retention period in days for audit logs
     */
    private int retentionDays = 90;

    /**
     * Cron expression for cleanup job
     */
    private String cleanupCron = "0 0 0 * * ?";

    public int getRetentionDays() {
        return retentionDays;
    }

    public void setRetentionDays(int retentionDays) {
        this.retentionDays = retentionDays;
    }

    public String getCleanupCron() {
        return cleanupCron;
    }

    public void setCleanupCron(String cleanupCron) {
        this.cleanupCron = cleanupCron;
    }

}
