package com.example.voluntariado.services;

import com.example.voluntariado.models.UserV;
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
    public List<UserV> getAllUsers(){
        return userRepository.getAllUsers();
    }

    @PostMapping("/register")
    public String register(@RequestBody UserV userV){
        return userRepository.createUser(userV);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserV userV){
        if(userRepository.findByUsername(userV.getUsername()) == null){
            return "BAD";
        }
        return userRepository.login(userV.getUsername(), userV.getPassword());
    }
}

