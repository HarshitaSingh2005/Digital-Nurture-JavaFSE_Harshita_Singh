package com.cognizant.spring_learn.Controller;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
public class AuthController {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthController.class);

    @GetMapping("/authenticate")
    public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
        LOGGER.info("Start");
        LOGGER.debug("Auth Header: {}", authHeader);

        String user = getUser(authHeader);
        
        String token = generateJwt(user);
        Map<String, String> response = new HashMap<>();
        response.put("token", token);

        LOGGER.info("End");
        return response;
    }

    private String getUser(String authHeader) {
        
        String encodedCredentials = authHeader.substring(6);
       
        byte[] decodedBytes = Base64.getDecoder().decode(encodedCredentials);
        String decodedString = new String(decodedBytes); // e.g., "user:pwd"
        
        // Split by colon and return just the username part
        return decodedString.split(":")[0];
    }

    private String generateJwt(String user) {
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(user);
        builder.setIssuedAt(new Date());
        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
        
        builder.signWith(SignatureAlgorithm.HS256, "secretkey");
        
        return builder.compact();
    }
}