package com.blog.controllers;

import com.blog.entities.TermUser;
import com.blog.entities.Users;
import com.blog.services.MailSender;
import com.blog.services.TermUserService;
import com.blog.services.UserService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class RegistrationController {
    @Autowired
    private MailSender mailSender;
    @Autowired
    private UserService userService;
    @Autowired
    private TermUserService termUserService;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new Users());

        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") @Valid TermUser usersForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        if (userService.findByUsername(usersForm.getUsername())!=null){
            model.addAttribute("usernameError", "User with this username already exists");
            return "registration";
        }
        if(termUserService.findByUsername(usersForm.getUsername())!=null)
        {
            model.addAttribute("usernameError2","this username is waiting for confirming, if after 24 hours it won't be available then it is taken");

        }
        if (!usersForm.getPassword().equals(usersForm.getPasswordConfirm())){
            model.addAttribute("passwordError", "Passwords don't match");
            return "registration";
        }
        usersForm.setPassword(bCryptPasswordEncoder.encode(usersForm.getPassword()));
        usersForm.setActivationCode(UUID.randomUUID().toString());
        String message= String.format("Hello %s.\n\nWelcome to StudentZ. " +
                "Go to this reference to activate your account https://localhost:8080/registration/activate/%s",
                usersForm.getUsername(),usersForm.getActivationCode());
        mailSender.send(usersForm.getEmail(),"Account Activation",message);



        return "confirming_page";
    }

    @GetMapping("https://studentz.herokuapp.com/registration/{activationCode}")
    public String activationAccount(@PathVariable("activationCode") String activationCode)
    {
        TermUser termUser=termUserService.findByActivationCode(activationCode);
        if(termUser!=null)
        {
            Users users=new Users();
            users.setUsername(termUser.getUsername());
            users.setEmail(termUser.getEmail());
            users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
            userService.saveUser(users);
            termUserService.delete(termUser.getId());
            return "success_registration";
        }
        else
        {
            return "denied_page";
        }



    }
}