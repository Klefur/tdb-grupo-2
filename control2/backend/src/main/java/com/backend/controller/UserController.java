package com.backend.controller;

import com.backend.model.User;
import com.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserRepository uRep;
    @GetMapping("/")
    public List<User> listAll() {
        return uRep.findAll();
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        System.out.println(user.getUsername() + " " + user.getPassword());
        return uRep.create(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        return uRep.login(user.getUsername(), user.getPassword());
    }
}
