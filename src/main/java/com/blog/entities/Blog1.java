package com.blog.entities;


import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="blog1")
public class Blog1 {


    private Long id;
    private String title;
    private String content;
    @Column(name = "created_at",updatable = false)
    private Date createdAt;
    private Date updatedAt;
    private String category;
    private String username;




    @PrePersist
    protected void onCreate() {
        if (createdAt==null){
            createdAt = new Date();
            updatedAt = createdAt;
        }
    }

    @PreUpdate
    protected void onUpdate() {


        updatedAt = new Date();
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public Blog1() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
