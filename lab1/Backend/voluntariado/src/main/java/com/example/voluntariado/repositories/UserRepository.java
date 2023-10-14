package com.example.voluntariado.repositories;

import com.example.voluntariado.models.UserV;

import java.util.List;

public interface UserRepository {
    public List<UserV> getAllUsers();
    public String createUser(UserV userV);
    public UserV findByUsername(String username);
    public String login(String username, String password);
}
