package com.example.voluntariado.services;

import com.example.voluntariado.models.User;
import com.example.voluntariado.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userRepository.getAllUsers();
    }

    @PostMapping("/register")
    public String register(@RequestBody User user){
        return userRepository.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        return userRepository.login(user.getUsername(), user.getPassword());
    }
}
