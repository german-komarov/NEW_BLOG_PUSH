package com.blog.entities.message;

import javax.persistence.*;
import java.util.Date;

@Entity
public class NewMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sender;
    private String receiver;
    private String content;
    private String subject;
    private Date receivedAt;
    private long sentid;

    public long getSent_id() {
        return sentid;
    }

    public void setSent_id(long sent_id) {
        this.sentid = sent_id;
    }

    @Transient
    private final String source="NewMessage";

    public String getSource() {
        return source;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Date getReceivedAt() {
        return receivedAt;
    }

    public void setReceivedAt(Date receivedAt) {
        this.receivedAt = receivedAt;
    }

    @PrePersist
    protected void onCreate()
    {
        receivedAt = new Date();
    }

    public NewMessage() {
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


}
