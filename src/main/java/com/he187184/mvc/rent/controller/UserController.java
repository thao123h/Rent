package com.he187184.mvc.rent.controller;

import com.he187184.mvc.rent.common.Role;
import com.he187184.mvc.rent.entity.User;
import com.he187184.mvc.rent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // GET /api/userss
    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findUsersByRole(Role.owner);
        System.out.println(users.size());
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
