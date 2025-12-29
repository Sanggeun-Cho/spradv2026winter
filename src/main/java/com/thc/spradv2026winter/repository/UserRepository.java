package com.thc.spradv2026winter.repository;

import com.thc.spradv2026winter.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username); // 0 1
    User findByNick(String nick); // 0 1
    User findByUsernameAndPassword(String email, String password); // 0 1
}
