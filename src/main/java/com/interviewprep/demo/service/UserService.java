package com.interviewprep.demo.service;

import com.interviewprep.demo.entity.AuditLog;
import com.interviewprep.demo.entity.User;
import com.interviewprep.demo.repository.AuditLogRepository;
import com.interviewprep.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuditLogRepository auditLogRepository;

    @Transactional(isolation = Isolation.READ_COMMITTED, rollbackFor = Exception.class)
    public void updateUserAndLog(User user) {
        userRepository.save(user);
        AuditLog log = new AuditLog("Updated user", user.getUsername());
        auditLogRepository.save(log);
    }

    public void createUserAndLog(User user) {
        userRepository.save(user);
        AuditLog log = new AuditLog("Created user", user.getUsername());
        auditLogRepository.save(log);
    }
}
