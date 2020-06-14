package com.blog.services;


import com.blog.entities.Message;
import com.blog.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
@Transactional
public class MessageService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private MessageRepository messageRepository;

    public Message getOneMessage(Long id)
    {
        if(messageRepository.findById(id).isPresent())
        {
            return messageRepository.findById(id).get();
        }

        else
        {
            return null;
        }
    }

    public List<Message> listAll()
    {
        return messageRepository.findAll();
    }


    public void save(Message message)
    {
        messageRepository.save(message);
    }

    public void delete(Long id)
    {
        messageRepository.deleteById(id);
    }


    public List<Message> getNewMessages(String username)
    {
        return entityManager.createQuery("select message from Message message where message.receiver like :paramReceiver and message.source like 'new' and message.deletedByReceiver=0",Message.class)
                .setParameter("paramReceiver",username).getResultList();
    }

    public List<Message> getCheckedMessages(String username)
    {
        return entityManager.createQuery("select message from Message message where message.receiver like :paramReceiver and message.source like 'checked' and message.deletedByReceiver=0",Message.class)
                .setParameter("paramReceiver",username).getResultList();
    }

    public List<Message> getSentMessages(String username)
    {
        return entityManager.createQuery("select message from Message message where message.sender like :paramSender and message.deletedBySender=0",Message.class)
                .setParameter("paramSender",username).getResultList();
    }




    public List<Message> getDeletedNewMessages(String username)
    {
        return entityManager.createQuery("select message from Message message where message.receiver like :paramUsername and message.deletedByReceiver=1 and message.source like 'new'",Message.class)
                .setParameter("paramUsername",username).getResultList();
    }

    public List<Message> getDeletedCheckedMessages(String username)
    {
        return entityManager.createQuery("select message from Message message where message.receiver like :paramUsername and message.deletedByReceiver=1 and message.source like 'checked'",Message.class)
                .setParameter("paramUsername",username).getResultList();
    }

    public List<Message> getDeletedSentMessages(String username)
    {
        return entityManager.createQuery("select message from Message message where message.sender like :paramUsername and message.deletedBySender=1",Message.class)
                .setParameter("paramUsername",username).getResultList();
    }




















    //    public List<Message> getDeletedMessages(String username)
//    {
//        return entityManager.createQuery("select message from Message message where message.sender like :paramUsername and message.deletedBySender=1 or message.receiver like :paramUsername and message.deletedByReceiver=1",Message.class)
//                .setParameter("paramUsername",username).getResultList();
//    }



}
