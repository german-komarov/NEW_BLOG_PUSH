package com.blog.controllers;


import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping("/blog/post")
    public String postUserBlog(Model model)
    {
        Post post=new Post();
        model.addAttribute("post",post);
        return "user_offer";
    }

    @PostMapping(value = "/blog/post/save")
    public String sendOffer(@ModelAttribute("post") Post post)
    {
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        post.setUsername(user.getUsername());
        postService.save(post);
        return "offer_success";
    }


}
