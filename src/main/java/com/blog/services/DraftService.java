package com.blog.services;

import java.util.List;

import com.blog.entities.Blog1;
import com.blog.entities.Draft;
import com.blog.repositories.DraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DraftService {

    @Autowired
    private DraftRepository repo;

    public List<Draft> listAll() {
        return repo.findAll();
    }

    public void save(Draft draft) {
        repo.save(draft);
    }

    public Draft get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }


}