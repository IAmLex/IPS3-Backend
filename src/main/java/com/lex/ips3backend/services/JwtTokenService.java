package com.lex.ips3backend.services;

import com.lex.ips3backend.models.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JwtTokenService {
    final private UserService userService;

    final private String _secret;
    final private Integer _expirationTime;
    final private String _prefix;

    public JwtTokenService(UserService userService) {
        this.userService = userService;

        this._secret = "VerySecretTokenYess";
        this._expirationTime = 28800000;
        this._prefix = "Bearer ";
    }

    public String createToken(User user) {
        String token = Jwts
                .builder()
                .setId("IPS3")
                .setSubject(user.getId().toString())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + this._expirationTime))
                .signWith(
                        SignatureAlgorithm.HS512,
                        this._secret.getBytes()
                )
                .compact();

        return this._prefix + token;
    }

    public void validateToken(String token) {
        // Example token:
        // "Bearer eyJhbGciOiJIUzUxMiJ9.eyJqdGkiOiJjaXRydXNjYXNlIiwic3ViIjoiTGV4IiwiaWF0IjoxNjA0NTg0OTYyLCJleHAiOjE2MDQ1ODU1NjJ9.U_N9uzHwI73752uE6jLGvtNWu83xv-_I-b0--wrQomE1eMlvbCmZovzLwCkT4LI2gI3COJODu4IsR-3a6DYMjw"
        String cleanToken;
        if (token.contains(this._prefix)) {
            cleanToken = token.substring(7);
        } else {
            cleanToken = token;
        }

        Claims tokenBody = Jwts.parser().setSigningKey(this._secret.getBytes()).parseClaimsJws(cleanToken).getBody();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(null, null, authorities);

        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
    }
}
