package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.User;
import com.example.voluntariado.repositories.JwtMiddlewareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import io.jsonwebtoken.*;
import javax.crypto.SecretKey;
import java.util.Date;

@Repository
public class JwtMiddlewareImp implements JwtMiddlewareRepository {
    private final SecretKey secretKey;

    @Autowired
    public JwtMiddlewareImp(SecretKey secretKey){
        this.secretKey = secretKey;
    }

    @Override
    public String generateToken(User user){
        Date expiration_date = new Date(System.currentTimeMillis() + 14400000);
        return Jwts
                .builder()
                .claim("id", user.getId())
                .claim("username", user.getUsername())
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expiration_date)
                .signWith(secretKey)
                .compact();
    }

    @Override
    public Boolean validateToken(String token){
        try{
            Jws<Claims> jws = Jwts
                    .parser()
                    .verifyWith(secretKey)
                    .build()
                    .parseSignedClaims(token);
            return !jws.getPayload().getExpiration().before(new Date());
        }catch(ExpiredJwtException e){
            e.printStackTrace();
            return false;
        }catch(MalformedJwtException e){
            e.printStackTrace();
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public User decodeJWT(String token){
        Claims claims = Jwts
                .parser()
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
