package com.blog.repositories;

import com.blog.entities.Draft;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DraftRepository extends JpaRepository<Draft,Long> {
}
