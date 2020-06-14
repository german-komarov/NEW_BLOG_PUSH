package com.blog.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;

@Entity
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sender;

    @NotBlank(message = "This field cannot be empty")
    @Size(min=5, max=30,message = "Here must be between 5 and 30 characters")
    private String receiver;


    private String subject;
    private String message;

    private Date time;

    private String source;

    private short deletedByReceiver;
    private short deletedBySender;

    @PrePersist
    private void onCreate()
    {
        time=new Date();
    }

    public Message() {
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public short getDeletedByReceiver() {
        return deletedByReceiver;
    }

    public void setDeletedByReceiver(short deletedByReceiver) {
        this.deletedByReceiver = deletedByReceiver;
    }

    public short getDeletedBySender() {
        return deletedBySender;
    }

    public void setDeletedBySender(short deletedBySender) {
        this.deletedBySender = deletedBySender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Message)) return false;
        Message message1 = (Message) o;
        return getSender().equals(message1.getSender()) &&
                getReceiver().equals(message1.getReceiver()) &&
                Objects.equals(getSubject(), message1.getSubject()) &&
                Objects.equals(getMessage(), message1.getMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSender(), getReceiver(), getSubject(), getMessage());
    }
}
