package com.blog.repositories;


import com.blog.entities.TermUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermUserRepository extends JpaRepository<TermUser,Long> {
    TermUser findByActivationCode(String activationCode);
    TermUser findByUsername(String username);
}
