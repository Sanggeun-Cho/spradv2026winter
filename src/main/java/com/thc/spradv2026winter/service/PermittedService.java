package com.thc.spradv2026winter.service;

import org.springframework.stereotype.Service;

@Service
public interface PermittedService {
    void check(String target, Integer func, Long userId);
    boolean ispermitted(String target, Integer func, Long userId);
}
