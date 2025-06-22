package com.springbootblogapplication.Spring.Boot.Blog.Application.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final String SECRET_KEY = "secret_key";  // Use a strong key in production
    private final long EXPIRATION_TIME=1000 * 60 * 5;

    public String generateToken(UserDetails userDetails){
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256,SECRET_KEY)
                .compact();
    }
    public String extractEmail(String token){
        return getClaims(token).getSubject();
    }
    public boolean validateToken(String token){
        try{
            Claims claims = getClaims(token);
            return !claims.getExpiration().before(new Date());
        }catch (JwtException | IllegalArgumentException e) {
           return false;
        }
    }
    private Claims getClaims(String token){
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
