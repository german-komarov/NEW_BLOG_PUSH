package com.blog.services.messageServices;


import com.blog.entities.message.CheckedMessage;
import com.blog.entities.message.NewMessage;
import com.blog.entities.message.SentMessage;
import com.blog.repositories.messageRepositories.NewMessageRepository;
import com.blog.repositories.messageRepositories.SentMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class SentMessageService {
    @Autowired
    private SentMessageRepository sentMessageRepository;

    @PersistenceContext
    private EntityManager em;

    public List<SentMessage> listAll() {
        return sentMessageRepository.findAll();
    }

    public void save(SentMessage sentMessage) {
        sentMessageRepository.save(sentMessage);
    }

    public SentMessage get(long id) {
        return sentMessageRepository.findById(id).get();
    }

    public void delete(long id) {
        sentMessageRepository.deleteById(id);
    }


    public List<SentMessage> sentMessagesList(String sender) {
        return em.createQuery("SELECT u FROM SentMessage  u WHERE u.sender like :paramSender", SentMessage.class)
                .setParameter("paramSender", sender).getResultList();
    }

    public SentMessage sentMessage(String sender,Long id) {
        return em.createQuery("SELECT u FROM SentMessage u WHERE u.sender like :paramSender and u.id = :paramId", SentMessage.class)
                .setParameter("paramSender", sender).setParameter("paramId",id).getSingleResult();
    }

}
