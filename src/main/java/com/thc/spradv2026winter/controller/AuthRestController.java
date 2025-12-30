package com.thc.spradv2026winter.controller;

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
    final TokenFactory tokenFactory;

    @PostMapping("") // 토큰 값 헤더에 담아서 주기
    public ResponseEntity<Void> access(HttpServletRequest request) {
        String refreshToken = request.getHeader("RefreshToken");
        if(!refreshToken.startsWith("Bearer")) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        refreshToken = refreshToken.substring(7);

        String accessToken = tokenFactory.createAccessToken(refreshToken);

        if(accessToken == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        return ResponseEntity.ok().header("Authorization", "Bearer " +  accessToken).build();
    }
}
