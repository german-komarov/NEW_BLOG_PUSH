package com.blog.services.messageServices;


import com.blog.entities.Draft;
import com.blog.entities.message.DeletedMessage;
import com.blog.entities.message.NewMessage;
import com.blog.repositories.messageRepositories.NewMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class NewMessageService {
    @PersistenceContext
    private EntityManager em;

    @Autowired
    private NewMessageRepository newMessageRepository;

    public List<NewMessage> listAll() {
        return newMessageRepository.findAll();
    }

    public void save(NewMessage newMessage) {
        newMessageRepository.save(newMessage);
    }

    public NewMessage get(long id) {
        return newMessageRepository.findById(id).get();
    }

    public void delete(long id) {
        newMessageRepository.deleteById(id);
    }

    public List<NewMessage> newMessagesList(String receiver) {
        return em.createQuery("SELECT u FROM NewMessage u WHERE u.receiver like :paramReceiver", NewMessage.class)
                .setParameter("paramReceiver", receiver).getResultList();
    }

    public NewMessage newMessage(String receiver,Long id) {
        return em.createQuery("SELECT u FROM NewMessage u WHERE u.receiver like :paramReceiver and u.id = :paramId", NewMessage.class)
                .setParameter("paramReceiver", receiver).setParameter("paramId",id).getSingleResult();
    }

    public List<NewMessage> findBySentid(long sentid) {
        return em.createQuery("SELECT u FROM NewMessage u WHERE u.sentid=:paramSentid", NewMessage.class)
                .setParameter("paramSentid", sentid).getResultList();
    }
}
