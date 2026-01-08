package com.thc.spradv2026winter.repository;

import com.thc.spradv2026winter.domain.Permissionuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionuserRepository extends JpaRepository<Permissionuser, Long> {
    Permissionuser findByPermissionIdAndUserId(Long permissionId, Long userId);

}