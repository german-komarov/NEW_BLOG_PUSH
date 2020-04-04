package com.blog.services.messageServices;


import com.blog.entities.message.CheckedMessage;
import com.blog.entities.message.DeletedMessage;
import com.blog.entities.message.NewMessage;
import com.blog.entities.message.SentMessage;
import com.blog.repositories.messageRepositories.DeletedMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class DeletedMessageService {
    @Autowired
    private DeletedMessageRepository deletedMessageRepository;

    @PersistenceContext
    private EntityManager em;

    public List<DeletedMessage> listAll() {
        return deletedMessageRepository.findAll();
    }

    public void save(DeletedMessage deletedMessage) {
        deletedMessageRepository.save(deletedMessage);
    }

    public DeletedMessage get(long id) {
        return deletedMessageRepository.findById(id).get();
    }

    public void delete(long id) {
        deletedMessageRepository.deleteById(id);
    }

    public List<DeletedMessage> deletedMessagesList(String deleter) {
        return em.createQuery("SELECT u FROM DeletedMessage u WHERE u.deleter like :paramDeleter", DeletedMessage.class)
                .setParameter("paramDeleter", deleter).getResultList();
    }

    public DeletedMessage deletedMessage(String deleter,Long id) {
        return em.createQuery("SELECT u FROM DeletedMessage u WHERE u.deleter like :paramDeleter and u.id = :paramId", DeletedMessage.class)
                .setParameter("paramDeleter", deleter).setParameter("paramId",id).getSingleResult();
    }


    public List<DeletedMessage> deletedNewMessagesList(String deleter) {
        return em.createQuery("SELECT u FROM DeletedMessage u WHERE u.deleter like :paramDeleter and u.deletedFrom like 'NewMessage'", DeletedMessage.class)
                .setParameter("paramDeleter", deleter).getResultList();
    }

    public List<DeletedMessage> deletedCheckedMessagesList(String deleter) {
        return em.createQuery("SELECT u FROM DeletedMessage u WHERE u.deleter like :paramDeleter and u.deletedFrom like 'CheckedMessage'", DeletedMessage.class)
                .setParameter("paramDeleter", deleter).getResultList();
    }

    public List<DeletedMessage> deletedSentMessagesList(String deleter) {
        return em.createQuery("SELECT u FROM DeletedMessage u WHERE u.deleter like :paramDeleter and u.deletedFrom like 'SentMessage'", DeletedMessage.class)
                .setParameter("paramDeleter", deleter).getResultList();
    }


    public List<DeletedMessage> findBySentid(long sentid) {
        return em.createQuery("SELECT u FROM DeletedMessage u WHERE u.sentid=:paramSentid", DeletedMessage.class)
                .setParameter("paramSentid", sentid).getResultList();
    }






}
