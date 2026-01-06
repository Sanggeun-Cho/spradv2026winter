package com.thc.spradv2026winter.repository;

import com.thc.spradv2026winter.domain.Permission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}