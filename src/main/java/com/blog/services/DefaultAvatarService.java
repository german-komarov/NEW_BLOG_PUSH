package com.blog.services;

import com.blog.entities.DefaultAvatar;
import com.blog.repositories.DefaultAvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultAvatarService {

    @Autowired
    private DefaultAvatarRepository defaultAvatarRepository;


    public List<DefaultAvatar> listAll()
    {
        return defaultAvatarRepository.findAll();
    }

    public DefaultAvatar getDefaultAvatar(Long id)
    {
        if(defaultAvatarRepository.findById(id).isPresent())
        {
            return defaultAvatarRepository.findById(id).get();
        }
        else
        {
            return null;
        }
    }


    public void deleteDefaultAvatar(Long id)
    {
        defaultAvatarRepository.deleteById(id);
    }


    public void saveDefaultAvatar(DefaultAvatar defaultAvatar)
    {
        defaultAvatarRepository.save(defaultAvatar);
    }

    public String defaultAvatar(String color)
    {
        return defaultAvatarRepository.findByColorOfPhoto(color).getPhoto();
    }


}
