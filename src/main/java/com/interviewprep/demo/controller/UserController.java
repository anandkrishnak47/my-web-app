package com.interviewprep.demo.controller;

import com.interviewprep.demo.entity.User;
import com.interviewprep.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        // Call the service method
        userService.updateUserAndLog(user);
        return ResponseEntity.ok("User updated and audit log created for " + user.getUsername());
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        // Call the service method
        userService.createUserAndLog(user);
        return ResponseEntity.ok("User created and audit log created for " + user.getUsername());
    }

}
