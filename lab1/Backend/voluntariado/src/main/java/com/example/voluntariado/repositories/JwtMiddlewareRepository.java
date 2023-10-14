package com.example.voluntariado.repositories;

import com.example.voluntariado.models.UserV;

public interface JwtMiddlewareRepository {
    public String generateToken(UserV userV);
    public Boolean validateToken(String token);

    public UserV decodeJWT(String token);
}
