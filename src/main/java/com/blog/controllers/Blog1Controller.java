package com.blog.controllers;


import com.blog.entities.*;
import com.blog.services.Blog1Service;
import com.blog.services.CommentService;
import com.blog.services.PostService;
import com.blog.services.messageServices.NewMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
import java.util.Set;


@Controller
public class Blog1Controller {

    @Autowired
    private Blog1Service service;

    @Autowired
    private CommentService commentService;



    @GetMapping("/main/blog")
    public String viewHomePage(Model model) {
        List<Blog1> listBlog1 = service.listAll();
        model.addAttribute("listBlog1", listBlog1);

        return "index";
    }

    //READ
    @GetMapping("/main/blog/text/{id}")
    public ModelAndView read(@PathVariable(name = "id") int id)
    {
        //List of comments
        List<Comment> listComments=commentService.listAll(id);
        //Creating model and view
        ModelAndView mav=new ModelAndView("read_page");
        //Getting blog
        Blog1 blog1=service.get(id);
        //Putting blog to model
        mav.addObject("blog1",blog1);
        //Putting counter
        mav.addObject("count",listComments.size());
        return mav;
    }

    @GetMapping("/main/blog/text/{id}/comments")
    public String comment(@PathVariable(name = "id") int id,Model model)
    {
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment comment=new Comment();
        comment.setBlogid(id);
        model.addAttribute("comment",comment);
        List<Comment> listComments=commentService.listAll(id);
        model.addAttribute("listComments",listComments);
        model.addAttribute("blogid",id);
        model.addAttribute("user",user.getUsername());
        return "comment_page";

    }

    @PostMapping(value = "/main/blog/text/comments/add")
    public String addComment(@ModelAttribute("comment") Comment comment)
    {
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        comment.setAuthor(user.getUsername());
        commentService.save(comment);
        String path="redirect:/main/blog/text/"+comment.getBlogid()+"/comments";
        return path;

    }
    //DELETE
    @GetMapping("/main/blog/text/{blogid}/comments/delete/{id}")
    public String deleteBlog(@PathVariable(name = "blogid") int blogid,@PathVariable(name="id") int id) {
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Comment comment=commentService.get((long)id);
        if (!comment.getAuthor().equals(user.getUsername()))
        {
            return "denied_page";
        }
        commentService.delete(id);
        String path="redirect:/main/blog/text/"+blogid+"/comments";
        return path;
    }


    //FILTER
    @PostMapping("/main/blog/filter")
    public String filter(@RequestParam String filter, Model model)
    {
        List<Blog1> listBlog1;


        if(filter!=null&&!filter.isEmpty())
        {
           listBlog1=service.findByCategory(filter);
        }
        else
        {
            listBlog1=service.listAll();
        }

        model.addAttribute("listBlog1", listBlog1);
        return "index";
    }








}