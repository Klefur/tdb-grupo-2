package com.example.voluntariado.repositories;

import com.example.voluntariado.models.User;

public interface JwtMiddlewareRepository {
    public String generateToken(User user);
    public Boolean validateToken(String token);

    public User decodeJWT(String token);
}
