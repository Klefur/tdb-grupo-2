package com.backend.repository;


import com.backend.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class JwtMiddleware {

    private final SecretKey secretKey;

    @Autowired
    public JwtMiddleware(SecretKey secretKey) {
        this.secretKey = secretKey;
    }

    public String generateToken(User user) {
        Date fecha_expiracion = new Date(System.currentTimeMillis() + 14400000);
        return Jwts.builder()
                .claim("id", user.getId())
                .claim("username", user.getUsername())
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(fecha_expiracion)
                .signWith(secretKey)
                .compact();
    }

    public Boolean validateToken(String token) {
        try {
            System.out.println(token);
            Jws<Claims> jws = Jwts.parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);
            return !jws.getPayload().getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            // El token ha expirado
            return false;
        } catch (MalformedJwtException e) {
            // El token es inválido o ha ocurrido un error de firma
            e.printStackTrace();
            return false; // Considera tokens malformados como expirados
        } catch (Exception e) {
            // Otras excepciones
            e.printStackTrace();
            return false; // Considera otras excepciones como expirados
        }
    }

    public User decodeJWT(String token) {
        Claims claims = Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();

        Long id = claims.get("id", Long.class);
        String username = claims.get("username", String.class);

        User user = new User();
        user.setId(id);
        user.setUsername(username);

        return user;
    }
}
