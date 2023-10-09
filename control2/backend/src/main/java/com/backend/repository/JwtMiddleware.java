package com.backend.repository;


import com.backend.model.User;
import io.jsonwebtoken.*;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtMiddleware {
    SecretKey key = Jwts.SIG.HS256.key().build();

    public String generateToken(User user) {
        Date fecha_expiracion = new Date(System.currentTimeMillis() + 14400000);
        System.out.println(fecha_expiracion);
        return Jwts.builder()
                .subject("Login Token")
                    .claim("user", user)
                    .issuedAt(new Date(System.currentTimeMillis()))
                    .expiration(fecha_expiracion)
                .signWith(key)
                .compact();
    }

    public Boolean validateToken(String token) {
        try {
            Jws<Claims> jws = Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parseSignedClaims(token);

            return !jws.getPayload().getExpiration().before(new Date());
        } catch (ExpiredJwtException e) {
            // El token ha expirado
            return true;
        } catch (MalformedJwtException e) {
            // El token es inválido o ha ocurrido un error de firma
            e.printStackTrace();
            return true; // Considera tokens malformados como expirados
        } catch (Exception e) {
            // Otras excepciones
            e.printStackTrace();
            return true; // Considera otras excepciones como expirados
        }
    }
}
