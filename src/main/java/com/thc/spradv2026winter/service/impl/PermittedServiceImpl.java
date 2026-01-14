package com.thc.spradv2026winter.service.impl;

import com.thc.spradv2026winter.dto.PermissionDto;
import com.thc.spradv2026winter.exception.NoPermissionException;
import com.thc.spradv2026winter.mapper.PermissionMapper;
import com.thc.spradv2026winter.service.PermissionService;
import com.thc.spradv2026winter.service.PermittedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class PermittedServiceImpl implements PermittedService {
    final PermissionMapper permissionMapper;

    @Override
    public void check(String target, Integer func, Long userId) {
        boolean isable = ispermitted(target, func, userId);
        if (!isable) {
            throw new NoPermissionException("No Permission");
        }
    }

    @Override
    public boolean ispermitted(String target, Integer func, Long userId) {
        if(userId != null && userId == (long) -200) {
            // 무조건 승인
            return true;
        }

        int listCount = permissionMapper.ispermitted(PermissionDto.IspermittedReqDto.builder()
                        .target(target)
                        .func(func)
                        .userId(userId)
                        .build());

        return listCount > 0;
    }
}
