package org.example.service;


import org.example.entities.RefreshTokens;
import org.example.entities.UserInfo;
import org.example.repository.RefreshTokenRepository;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

@Service
public class RefreshTokenService {

    @Autowired
    RefreshTokenService refreshTokenRepository;

    @Autowired
    UserRepository userRepository;

    public RefreshTokens createRefreshToken(String username){
        UserInfo userInfoExtracted = userRepository.findByUsername(username);
        RefreshTokens refreshToken = RefreshTokens.builder()
                .userInfo(userInfoExtracted)
                .token(UUID.randomUUID().toString())
                .expiryDate(Instant.now().plusMillis(600000))
                .build();
        return refreshTokenRepository.save(refreshToken);
    }

    public Optional<RefreshTokens> findByToken(String token){
        return refreshTokenRepository.findByToken(token);
    }

    public RefreshTokens verifyExpiration(RefreshTokens token){
        if(token.getExpiryDate().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(token);
            throw new RuntimeException(token.getToken() + " Refresh token is expired. Please make a new login..!");
        }
        return token;
    }




}
