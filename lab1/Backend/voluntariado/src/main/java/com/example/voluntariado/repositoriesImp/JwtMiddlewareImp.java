package com.example.voluntariado.repositoriesImp;

import com.example.voluntariado.models.UserV;
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
    public String generateToken(UserV userV){
        Date expiration_date = new Date(System.currentTimeMillis() + 14400000);
        return Jwts
                .builder()
                .claim("id", userV.getId())
                .claim("username", userV.getUsername())
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
    public UserV decodeJWT(String token){
        Claims claims = Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        Long id = claims.get("id", Long.class);
        String username = claims.get("username", String.class);

        UserV userV = new UserV();
        userV.setId(id);
        userV.setUsername(username);
        return userV;
    }
}
