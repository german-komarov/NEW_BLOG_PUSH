package com.blog.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DefaultAvatar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String colorOfPhoto;

    private String photo;


    public DefaultAvatar() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getColorOfPhoto() {
        return colorOfPhoto;
    }

    public void setColorOfPhoto(String colorOfPhoto) {
        this.colorOfPhoto = colorOfPhoto;
    }
}
