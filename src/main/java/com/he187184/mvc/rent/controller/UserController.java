package com.he187184.mvc.rent.controller;

import com.he187184.mvc.rent.common.Role;
import com.he187184.mvc.rent.entity.User;
import com.he187184.mvc.rent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    // GET /api/users
    @GetMapping("all")
    public List<User> getUsers(){
        return userRepository.findByRoleIsNot(Role.admin);
    }

}
