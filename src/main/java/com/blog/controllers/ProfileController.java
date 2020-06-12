package com.blog.controllers;


import com.blog.entities.Users;
import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;

@Controller
public class ProfileController {

    @Autowired
    private UserService userService;

    @GetMapping("/main/user_profile")
    public String profileOfTheUser(@AuthenticationPrincipal Users users, Model model)
    {
        model.addAttribute("username",users.getUsername());
        model.addAttribute("status",users.getStatus());
        model.addAttribute("avatar",users.getAvatar());
        model.addAttribute("description",users.getProfileDescription());
        return "profile_of_user";
    }


    @GetMapping("/main/user_profile/changeAvatar")
    public String getChangeAvatar()
    {
        return "change_avatar";
    }

    @PostMapping(value = "/main/user_profile/changeAvatar",consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String postChangeAvatar(@AuthenticationPrincipal Users users,@RequestParam MultipartFile multipartFile)
    {
        try {
            users.setAvatar(Base64.getEncoder().encodeToString(multipartFile.getBytes()));
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }

        userService.saveUser(users);
        return "redirect:/main/user_profile";

    }


    @GetMapping("/main/user_profile/changeStatus")
    public String getChangeStatus(@AuthenticationPrincipal Users users,Model model)
    {
        model.addAttribute("status",users.getStatus());
        return "change_status";
    }

    @PostMapping("/main/user_profile/changeStatus")
    public String postChangeStatus(@AuthenticationPrincipal Users users,@RequestParam String status)
    {
        users.setStatus(status);
        userService.saveUser(users);
        return "redirect:/main/user_profile";
    }



    @GetMapping("main/user_profile/changeDescription")
    public String getChangeDescription(@AuthenticationPrincipal Users users,Model model)
    {
        model.addAttribute("description",users.getProfileDescription());
        return "change_profile_description";
    }

    @PostMapping("main/user_profile/changeDescription")
    public String postChangeDescription(@AuthenticationPrincipal Users users,@RequestParam String description)
    {
        users.setProfileDescription(description);
        userService.saveUser(users);
        return "redirect:/main/user_profile";
    }









}
