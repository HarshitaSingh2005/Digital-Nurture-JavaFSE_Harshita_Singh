package com.cognizant.springlearn.controller;

import io.jsonwebtoken.Jwts;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.crypto.SecretKey;
import io.jsonwebtoken.security.Keys;

import java.util.Date;

@RestController
public class AuthenticationController {

    @GetMapping("/authenticate")
    public String authenticate(Authentication authentication) {

        String userName = authentication.getName();

        SecretKey key =
                Keys.hmacShaKeyFor(
                        "mysecretkeymysecretkeymysecretkey12"
                                .getBytes()
                );

        String token = Jwts.builder()
                .subject(userName)
                .issuedAt(new Date())
                .signWith(key)
                .compact();

        return token;
    }
}