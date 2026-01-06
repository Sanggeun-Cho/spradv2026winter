package com.thc.spradv2026winter.repository;

import com.thc.spradv2026winter.domain.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RoleTypeRepository extends JpaRepository<RoleType, String>{
    RoleType findByTypeName(String typeName);
}
