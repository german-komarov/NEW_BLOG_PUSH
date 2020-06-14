package com.blog.repositories;


import com.blog.entities.TermUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TermUserRepository extends JpaRepository<TermUser,Long> {
    TermUser findByUsername(String username);
}
