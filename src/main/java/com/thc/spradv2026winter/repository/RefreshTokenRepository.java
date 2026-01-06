package com.thc.spradv2026winter.repository;

import com.thc.spradv2026winter.domain.RefreshToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
    Optional<RefreshToken> findByContent(String content);
    List<RefreshToken> findByUserId(Long userId);
}
