package com.blog.controllers;

import com.blog.entities.DefaultAvatar;
import com.blog.services.DefaultAvatarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@RestController
public class TermController {

    @Autowired
    private DefaultAvatarService defaultAvatarService;


    @PostMapping(value = "/addDefaultAvatar",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public HttpStatus add(@RequestParam String name, @RequestParam MultipartFile multipartFile) throws IOException {
        DefaultAvatar defaultAvatar=new DefaultAvatar();
        defaultAvatar.setColorOfPhoto(name);
        defaultAvatar.setPhoto(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        defaultAvatarService.saveDefaultAvatar(defaultAvatar);
        return HttpStatus.OK;
    }
}
