package com.blog.controllers;


import com.blog.entities.Blog1;
import com.blog.entities.Role;
import com.blog.entities.Users;
import com.blog.services.Blog1Service;
import com.blog.services.MessageService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Set;

@Controller
public class MainController {
    @Autowired
    private Blog1Service blog1Service;

    @Autowired
    private MessageService messageService;

    @GetMapping("/")
    public String enterPage(Model model)
    {
        List<Blog1> listBlog1=blog1Service.listAll();
        model.addAttribute("listBlog1",listBlog1);
        return "entering_page";
    }



    @GetMapping("/main")
    public String main_page(@AuthenticationPrincipal Users users, Model model)
    {

        Set<Role> roleSet= users.getRoles();
        for (Role role:roleSet)
        {
            if (role.getName().equals("ROLE_MODERATOR"))
            {
                model.addAttribute("role","moderator");
                model.addAttribute("counter",messageService.getNewMessages(users.getUsername()).size());
                return "main_page";
            }

            else if(role.getName().equals("ROLE_ADMIN"))
            {
                model.addAttribute("role","admin");
                model.addAttribute("counter",messageService.getNewMessages(users.getUsername()).size());
                return "main_page";
            }
        }
        model.addAttribute("counter",messageService.getNewMessages(users.getUsername()).size());

        model.addAttribute("role","not_admin");

        return "main_page";
    }

    //READ
    @GetMapping("/read/{id}")
    public String read(@PathVariable(name = "id") int id,Model model)
    {
      Blog1 blog1=blog1Service.get(id);
      model.addAttribute("blog1",blog1);
      return "read_for_not_users";


    }

    //FILTER
    @PostMapping("/filter")
    public String filterNotUser(@RequestParam String filter, Model model)
    {
        List<Blog1> listBlog1;


        if(filter!=null&&!filter.isEmpty())
        {
            listBlog1=blog1Service.findByCategoryModified(filter);
        }
        else
        {
            listBlog1=blog1Service.listAll();
        }

        model.addAttribute("listBlog1", listBlog1);
        return "entering_page";
    }


}
