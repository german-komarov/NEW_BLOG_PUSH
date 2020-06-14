package com.blog.services;


import com.blog.entities.TermUser;
import com.blog.entities.Users;
import com.blog.repositories.TermUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class TermUserService {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private TermUserRepository termUserRepository;


    public List<TermUser> listAll() {
        return termUserRepository.findAll();
    }

    public void save(TermUser termUser) {
        termUserRepository.save(termUser);
    }

    public TermUser get(long id) {
        return termUserRepository.findById(id).get();
    }

    public void delete(long id) {
        termUserRepository.deleteById(id);
    }

    public TermUser findByUsername(String username)
    {
        return termUserRepository.findByUsername(username);
    }

    public TermUser findByActivationCode(String activationCode)
    {
        List<TermUser> termUserList=entityManager.createQuery("select termUser from TermUser termUser where termUser.activationCode like :paramActivationCode",TermUser.class)
                .setParameter("paramActivationCode",activationCode)
                .getResultList();

        if(termUserList.isEmpty())
        {
            return null;
        }
        else
        {
            return termUserList.get(0);
        }
    }

    public List<TermUser> findWithEmail(String email)
    {
        return entityManager.createQuery("select u from TermUser u where u.email like :paramEmail",TermUser.class)
                .setParameter("paramEmail",email).getResultList();
    }
}
