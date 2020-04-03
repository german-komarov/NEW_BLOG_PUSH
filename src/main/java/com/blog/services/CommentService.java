package com.blog.services;



import com.blog.entities.Comment;
import com.blog.entities.Post;
import com.blog.repositories.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public List<Comment> listAll(int id) {
        return commentRepository.findByBlogid(id);
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public Comment get(long id) {
        return commentRepository.findById(id).get();
    }

    public void delete(long id) {
        commentRepository.deleteById(id);
    }

    public List<Comment> findByBlogid(int id)
    {
        return commentRepository.findByBlogid(id);
    }
}
