package com.blog.services;

import java.util.List;


import com.blog.entities.Post;

import com.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> listAll() {
        return repo.findAll();
    }

    public void save(Post post) {
        repo.save(post);
    }

    public Post get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }


}