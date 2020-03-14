package com.blog.services;

import java.util.List;

import com.blog.entities.Blog1;
import com.blog.repositories.Blog1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class Blog1Service {

    @Autowired
    private Blog1Repository repo;

    public List<Blog1> listAll() {
        return repo.findAll();
    }

    public void save(Blog1 blog1) {
        repo.save(blog1);
    }

    public Blog1 get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

    public List<Blog1> findByCategory(String category)
    {
        return repo.findByCategory(category);
    }
}