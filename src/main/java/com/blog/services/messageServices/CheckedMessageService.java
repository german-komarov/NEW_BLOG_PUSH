package com.blog.services.messageServices;


import com.blog.entities.Blog1;
import com.blog.entities.message.CheckedMessage;
import com.blog.entities.message.NewMessage;
import com.blog.repositories.messageRepositories.CheckedMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CheckedMessageService {
    @Autowired
    private CheckedMessageRepository checkedMessageRepository;

    @PersistenceContext
    private EntityManager em;

    public List<CheckedMessage> listAll() {
        return checkedMessageRepository.findAll();
    }

    public void save(CheckedMessage checkedMessage) {
        checkedMessageRepository.save(checkedMessage);
    }

    public CheckedMessage get(long id) {
        return checkedMessageRepository.findById(id).get();
    }

    public void delete(long id) {
        checkedMessageRepository.deleteById(id);
    }

    public List<CheckedMessage> checkedMessagesList(String receiver) {
        return em.createQuery("SELECT u FROM CheckedMessage  u WHERE u.receiver like :paramReceiver", CheckedMessage.class)
                .setParameter("paramReceiver", receiver).getResultList();
    }

    public CheckedMessage checkedMessage(String receiver,Long id) {
        return em.createQuery("SELECT u FROM CheckedMessage u WHERE u.receiver like :paramReceiver and u.id = :paramId", CheckedMessage.class)
                .setParameter("paramReceiver", receiver).setParameter("paramId",id).getSingleResult();
    }


}
