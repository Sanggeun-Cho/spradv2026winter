package com.thc.spradv2026winter.repository;

import com.thc.spradv2026winter.domain.Posting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostingRepository extends JpaRepository<Posting, Long> {
}
