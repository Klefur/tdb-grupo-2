package com.example.voluntariado.repositories;

import com.example.voluntariado.models.User;

import java.util.List;

public interface UserRepository {
    public List<User> getAllUsers();
    public String createUser(User user);
    public User findByUsername(String username);
    public String login(String username, String password);
}
