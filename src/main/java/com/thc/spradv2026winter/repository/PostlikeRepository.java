package com.thc.spradv2026winter.repository;

import com.thc.spradv2026winter.domain.Postlike;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostlikeRepository extends JpaRepository<Postlike, Long> {
    Postlike findByPostingIdAndUserId(Long postingId, Long userId);
}
