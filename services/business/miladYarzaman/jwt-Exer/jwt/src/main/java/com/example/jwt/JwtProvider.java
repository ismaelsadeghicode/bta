package com.example.jwt;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component 
public class JwtProvider {
    private final String secret="secretsecretsecretsecretsecretsecretsecretsecret";
    public String generateToken(UserDetails userDetails) {
        Map<String,?> map=new HashMap<>();
        return createToken(map,userDetails);
    }

    private String createToken(Map<String,?> map, UserDetails userDetails) {
        return Jwts.builder()
              //  .setClaims((Claims) map)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+1000*60*60*1))
                .signWith(SignatureAlgorithm.HS256,secret)////////private Key
                .compact();
    }
    private Claims extractClaimsFromToken(String token){
        return Jwts.parser()
                .setSigningKey(secret)//////publicKey
                .parseClaimsJws(token)
                .getBody();
    }
    public boolean validateToken(String token,UserDetails userDetails){
        String userName= extractClaimsFromToken(token).getSubject();
        return userDetails.getUsername().equals(userName) && !isTokenExpire(token);

    }

    private boolean isTokenExpire(String token) {
        Claims claims=extractClaimsFromToken(token);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }

    public String getUserName(String token){
        Claims claims=extractClaimsFromToken(token);
        return claims.getSubject();
    }
}
