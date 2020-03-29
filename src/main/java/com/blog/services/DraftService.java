package com.blog.services;

import java.util.List;

import com.blog.entities.Blog1;
import com.blog.entities.Draft;
import com.blog.entities.User;
import com.blog.repositories.DraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class DraftService {

    @PersistenceContext
    private EntityManager em;

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

    public List<Draft> draftgtList(String username) {
        return em.createQuery("SELECT u FROM Draft u WHERE u.username like :paramUsername", Draft.class)
                .setParameter("paramUsername", username).getResultList();
    }


}