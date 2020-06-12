package com.blog.repositories;

import com.blog.entities.Blog1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Blog1Repository extends JpaRepository<Blog1,Long> {

    List<Blog1> findByCategory(String topic);

}
