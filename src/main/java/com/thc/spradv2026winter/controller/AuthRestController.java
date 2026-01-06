package com.thc.spradv2026winter.controller;

import com.thc.spradv2026winter.security.AuthService;
import com.thc.spradv2026winter.security.ExternalProperties;
import com.thc.spradv2026winter.util.TokenFactory;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/auth")
@RestController
public class AuthRestController {
    //    final TokenFactory tokenFactory;
    final AuthService authService;
    final ExternalProperties externalProperties;

    @PostMapping("") // 토큰 값 헤더에 담아서 주기
    public ResponseEntity<Void> access(HttpServletRequest request) {
        String refreshToken = request.getHeader("RefreshToken");
        String accessToken = null;
        if(refreshToken != null && refreshToken.startsWith(externalProperties.getTokenPrefix())) {
            String token = refreshToken.substring(externalProperties.getTokenPrefix().length());
            accessToken = authService.issueAccessToken(token);
        }

        return ResponseEntity.ok().header(externalProperties.getAccessKey(), externalProperties.getTokenPrefix() +  accessToken).build();
    }
}