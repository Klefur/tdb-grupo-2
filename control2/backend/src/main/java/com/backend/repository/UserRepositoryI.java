package com.backend.repository;

import com.backend.model.User;

import java.util.List;

public interface UserRepositoryI {
    public String create(User user);
    public List<User> findAll();
    public User findByUsername(String username);
    public String login(String username, String password);
}
