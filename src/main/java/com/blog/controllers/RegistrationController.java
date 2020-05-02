package com.blog.controllers;

import com.blog.entities.Users;
import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new Users());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid Users usersForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (!usersForm.getPassword().equals(usersForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Passwords don't match");
            return "registration";
        }
        if (!userService.saveUser(usersForm)){
            model.addAttribute("usernameError", "User with this username already exists");
            return "registration";
        }

        return "login";
    }
}