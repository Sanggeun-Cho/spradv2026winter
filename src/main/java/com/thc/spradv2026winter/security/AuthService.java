package com.thc.spradv2026winter.security;

import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

public interface AuthService {
    Algorithm getTokenAlgorithm();
    String cretaeAccessToken(Long userId);
    Long verifyAccessToken(String accessToken) throws JWTVerificationException;
    String createRefreshToken(Long userId);
    void revokeRefreshToken(Long userId);
    Long verifyRefreshToken(String refreshToken) throws JWTVerificationException;
    String issueAccessToken(String refreshToken) throws JWTVerificationException;
}
