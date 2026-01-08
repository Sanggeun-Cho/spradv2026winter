package com.thc.spradv2026winter.repository;

import com.thc.spradv2026winter.domain.Permissiondetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissiondetailRepository extends JpaRepository<Permissiondetail, Long> {
    Permissiondetail findByPermissionIdAndTargetAndFunc(Long permissionId, String target, Integer func);

}