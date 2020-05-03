package com.blog.services;


import com.blog.entities.TermUser;
import com.blog.repositories.TermUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TermUserService {

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
        return termUserRepository.findByActivationCode(activationCode);
    }
}
