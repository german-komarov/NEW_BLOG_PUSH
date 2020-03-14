package com.blog.controllers;


import com.blog.entities.Blog1;
import com.blog.entities.Post;
import com.blog.services.Blog1Service;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;


@Controller
public class Blog1Controller {

    @Autowired
    private Blog1Service service;

    @Autowired
    private PostService postService;

    HashMap<Long, Date> creation=new HashMap<>();






    @GetMapping("/")
    public String main_page()
    {
        return "main_page";
    }


    @GetMapping("/blog")
    public String viewHomePage(Model model) {
        List<Blog1> listBlog1 = service.listAll();
        model.addAttribute("listBlog1", listBlog1);

        return "index";
    }

    @GetMapping("/admin/blog_admin/new")
    public String showNewProductPage(Model model) {
        Blog1 blog1 = new Blog1();
        model.addAttribute("blog1", blog1);

        return "new_text";
    }

    @GetMapping("/admin/blog_admin")
    public String admin_page(Model model)
    {

        List<Blog1> listBlog1 = service.listAll();
        for (Blog1 bl:listBlog1)
        {
            creation.put(bl.getId(),bl.getCreatedAt());
        }
        model.addAttribute("listBlog1", listBlog1);
        return "index_for_admin";
    }




    //Save
    @PostMapping(value = "/admin/blog_admin/save")
    public String saveProduct(@ModelAttribute("blog1") Blog1 blog1) {
        service.save(blog1);
        return "redirect:/admin/blog_admin";
    }

    @PostMapping(value = "/admin/blog_admin/edit/save")
    public String saveEditedBlog(@ModelAttribute("blog1") Blog1 blog1)
    {
        long id =blog1.getId();
        blog1.setCreatedAt(creation.get(id));
        service.save(blog1);

        return "redirect:/admin/blog_admin";
    }


    @GetMapping("/admin/blog_admin/offers")
    public String offersToAdmin(Model model)
    {
        List<Post> listPost=postService.listAll();
        model.addAttribute("listPost",listPost);
        return "offers_to_admin";
    }

    @GetMapping("/admin/blog_admin/offers/text/{id}")
    public ModelAndView readOffers(@PathVariable(name = "id") int id)
    {
        ModelAndView mav=new ModelAndView("read_offers_page");
        Post post=postService.get(id);
        mav.addObject(post);
        return mav;

    }

    //EDIT
    @GetMapping("/admin/blog_admin/offers/edit/{id}")
    public ModelAndView editOfferPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_offer");
        Post post=postService.get(id);
        mav.addObject("post",post);

        return mav;
    }

    @PostMapping(value = "/admin/blog_admin/offers/edit/save")
    public String saveEditedOffer(@ModelAttribute("post") Post post)
    {
        postService.save(post);
        return "redirect:/admin/blog_admin/offers";
    }

    //DELETE
    @GetMapping("/admin/blog_admin/offers/delete/{id}")
    public String deleteOffer(@PathVariable(name = "id") int id) {
        postService.delete(id);
        return "redirect:/admin/blog_admin/offers";
    }



    @GetMapping("/admin/blog_admin/offers/accept/{id}")
    public String acceptOffer(Model model,@PathVariable(name = "id") int id)
    {
        Post post=postService.get(id);
        Blog1 blog1=new Blog1();
        blog1.setTitle(post.getTitle());
        blog1.setContent(post.getContent());
        blog1.setUsername(post.getUsername());
        blog1.setCategory(post.getCategory());
        model.addAttribute("blog1",blog1);
        return "new_text";

    }






    //ADMIN PAGE
    @GetMapping("/admin")
    public String admin()
    {
        return "admin";
    }

    //READ
    @GetMapping("/text/{id}")
    public ModelAndView read(@PathVariable(name = "id") int id)
    {
        ModelAndView mav=new ModelAndView("read_page");
        Blog1 blog1=service.get(id);
        mav.addObject(blog1);
        return mav;

    }





    //EDIT
    @GetMapping("/admin/blog_admin/edit/{id}")
    public ModelAndView showEditBlogPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_blog");
        Blog1 blog1 = service.get(id);
        mav.addObject("blog1",blog1);

        return mav;
    }

    //DELETE
    @GetMapping("/admin/blog_admin/delete/{id}")
    public String deleteBlog(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/admin/blog_admin";
    }


    //FILTER
    @PostMapping("/blog/filter")
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