package com.mapsa.springsecurity.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtProvider {
    private final String SECRET="iaughiqurghriuargohaperghwergiuwhepuogfhpoirhgg";

    public String generateToken(UserDetails userDetails) {
        Map<String,?> map= new HashMap<>();
        return createToken(map,userDetails);
    }

    private String createToken(Map<String, ?> map, UserDetails userDetails) {

        return Jwts.builder().setClaims(map).setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(
                        new Date(System.currentTimeMillis()+1000*60*60))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();
    }

    private Claims extractClaimsFromToken(String token){
        return Jwts.parserBuilder().setSigningKey(SECRET).build().parseClaimsJws(token).getBody();
    }

    public Boolean validateToken(String token,UserDetails userDetails){
        String username=extractClaimsFromToken(token).getSubject();
        return userDetails.getUsername().equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        Claims claims=extractClaimsFromToken(token);
        return claims.getExpiration().before(new Date(System.currentTimeMillis()));
    }

    public String getUsername(String token){
        Claims claims=extractClaimsFromToken(token);
        return claims.getSubject();
    }
}
