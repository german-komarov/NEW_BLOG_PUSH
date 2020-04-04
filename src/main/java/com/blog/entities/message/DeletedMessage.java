package com.blog.entities.message;


import javax.persistence.*;
import java.util.Date;

@Entity
public class DeletedMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sender;
    private String receiver;
    private String deleter;
    private String content;
    private String subject;
    private Date originalTime;
    private Date deletedAt;
    private long sentid;

    public long getSent_id() {
        return sentid;
    }

    public void setSent_id(long sent_id) {
        this.sentid = sent_id;
    }

    private String deletedFrom;


    public String getDeleter() {
        return deleter;
    }

    public void setDeleter(String deleter) {
        this.deleter = deleter;
    }

    public String getDeletedFrom() {
        return deletedFrom;
    }

    public void setDeletedFrom(String deletedFrom) {
        this.deletedFrom = deletedFrom;
    }

    @PrePersist
    protected void onCreate()
    {
        deletedAt = new Date();
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public DeletedMessage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getOriginalTime() {
        return originalTime;
    }

    public void setOriginalTime(Date originalTime) {
        this.originalTime = originalTime;
    }
}
