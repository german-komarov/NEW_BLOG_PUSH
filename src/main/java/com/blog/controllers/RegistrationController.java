package com.blog.controllers;

import com.blog.entities.Role;
import com.blog.entities.TermUser;
import com.blog.entities.Users;
import com.blog.services.RegistrationMailSender;
import com.blog.services.TermUserService;
import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Controller
public class RegistrationController {
    @Autowired
    private RegistrationMailSender mailSender;
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
            model.addAttribute("error", "User with this username already exists");
            return "registration";
        }
        if(!userService.findWithEmail(usersForm.getEmail()).isEmpty())
        {
            model.addAttribute("error", "User with this email already exists");
            return "registration";
        }
        if(termUserService.findByUsername(usersForm.getUsername())!=null)
        {
            model.addAttribute("error","this username is waiting for confirming, if after 24 hours it won't be available then it is taken");

        }
        if (!usersForm.getPassword().equals(usersForm.getPasswordConfirm())){
            model.addAttribute("error", "Passwords are different from each other");
            return "registration";
        }
        usersForm.setPassword(bCryptPasswordEncoder.encode(usersForm.getPassword()));
        usersForm.setActivationCode(UUID.randomUUID().toString());
        termUserService.save(usersForm);
        String message= String.format("Hello %s.\n\nWelcome to StudentZ. " +
                "Go to this reference to activate your account https://studentz.herokuapp.com/registration/activate/%s",
                usersForm.getUsername(),usersForm.getActivationCode());
        mailSender.send(usersForm.getEmail(),"Account Activation",message);



        return "confirming_page";
    }

    @GetMapping("/registration/activate/{activationCode}")
    public String activationAccount(@PathVariable("activationCode") String activationCode)
    {
        TermUser termUser=termUserService.findByActivationCode(activationCode);

        if(termUser!=null) {

            if(termUser.getEmail().endsWith("@ufaz.az") && termUser.getCounter()==0)
            {

                termUser.setCounter(1);
                termUserService.save(termUser);

                return "success_registration";
            }
            else if(termUser.getEmail().endsWith("@ufaz.az") && termUser.getCounter()==1)
            {
                Users users = new Users();
                users.setUsername(termUser.getUsername());
                users.setEmail(termUser.getEmail());
                users.setPassword(termUser.getPassword());
                users.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
                userService.saveUser(users);
                termUserService.delete(termUser.getId());


                return "success_registration";
            }
            Users users = new Users();
            users.setUsername(termUser.getUsername());
            users.setEmail(termUser.getEmail());
            users.setPassword(termUser.getPassword());
            users.setRoles(Collections.singleton(new Role(1L, "ROLE_USER")));
            userService.saveUser(users);
            termUserService.delete(termUser.getId());


                return "success_registration";

        }
            else
            {
                return "denied_page";
            }

    }


    @GetMapping("/login/restore_password")
    public String getRestorePassword()
    {
        return "restore_password_page";
    }

    @PostMapping("/login/restore_password")
    public String postRestorePassword(@RequestParam("email") String email)
    {
        List<Users> usersList=userService.findWithEmail(email);
        String message;
        if(usersList.isEmpty())
        {
            message="Hello.\n" +
                    "We could't find account associated with this email.\n" +
                    "You can pass registration following this link : http://studentz.herokuapp.com/registration\n\n\n" +
                    "If you didn't fill the form for restoring password, you can just ignore this email.\n" +
                    "Best regards. Administration of Studentz portal.";
            mailSender.send(email,"Password Restoring",message);
        }

        else
        {
            Users users=usersList.get(0);
            List<TermUser> termUserList=termUserService.findWithEmail(email);
            TermUser termUser = new TermUser();
            if(termUserList.isEmpty()) {

                termUser.setUsername(users.getUsername());
                termUser.setPassword(users.getPassword());
                termUser.setCounter(0);
                termUser.setActivationCode(UUID.randomUUID().toString());
                termUser.setEmail(users.getEmail());
            }
            else
            {
                termUser=termUserList.get(0);
                termUser.setActivationCode(UUID.randomUUID().toString());
            }
            termUserService.save(termUser);
            message=String.format("Hello, dear %s\n" +
                    "You can restore your password following this link http://studentz.herokuapp.com/login/restore_password/%s\n\n" +
                            "If you didn't require for password restoring, please just ignore this email\n" +
                            "Best regards. Administration of Studentz portal.",
                    users.getUsername(),termUser.getActivationCode());
            mailSender.send(email,"password Restoring",message);

        }
        return "restoring_message_was_sent";
    }


    @GetMapping("/login/restore_password/{restoringCode}")
    public String getRestorePasswordWithRestoringCode(@PathVariable("restoringCode") String restoringCode,Model model)
    {
        TermUser termUser=termUserService.findByActivationCode(restoringCode);
        if(termUser!=null)
        {
            if(termUser.getEmail().endsWith("@ufaz.az") && termUser.getCounter()==0)
            {
                termUser.setCounter(1);
                return "empty_page";
            }
            else
            {
                model.addAttribute("restoringCode",restoringCode);
                return "restoring_password_form";
            }
        }
        else
        {
            return "denied_page";
        }
    }



    @PostMapping("/login/restore_password/{restoringCode}")
    public String postRestorePasswordWithRestoringCode(@PathVariable("restoringCode") String restoringCode,
                                                       @RequestParam String password,
                                                       @RequestParam String passwordConfirm)
    {

        TermUser termUser=termUserService.findByActivationCode(restoringCode);
        if(termUser!=null)
        {
            if(password.equals(passwordConfirm))
            {
                List<Users> users=userService.findWithEmail(termUser.getEmail());
                users.get(0).setPassword(bCryptPasswordEncoder.encode(password));
                userService.saveUser(users.get(0));
                return "password_was_restored_successfully";
            }
            else
            {
                return "restoring_password_form";
            }
        }
        else
        {
            return "denied_page";
        }

    }

}


