package com.blog.controllers;


import com.blog.entities.Blog1;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.services.Blog1Service;
import com.blog.services.PostService;
import com.blog.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserService userService;


    @Autowired
    private Blog1Service service;

    @Autowired
    private PostService postService;

    HashMap<Long, Date> creation=new HashMap<>();

    @GetMapping("/main/admin/blog_admin/new")
    public String showNewProductPage(Model model) {
        Blog1 blog1 = new Blog1();
        model.addAttribute("blog1", blog1);

        return "new_text";
    }

    @GetMapping("/main/admin/blog_admin")
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
    @PostMapping(value = "/main/admin/blog_admin/save")
    public String saveProduct(@ModelAttribute("blog1") Blog1 blog1) {
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        blog1.setUsername(user.getUsername());
        service.save(blog1);
        return "redirect:/main/admin/blog_admin";
    }

    @PostMapping(value = "/main/admin/blog_admin/edit/save")
    public String saveEditedBlog(@ModelAttribute("blog1") Blog1 blog1)
    {
        long id =blog1.getId();
        blog1.setCreatedAt(creation.get(id));
        service.save(blog1);

        return "redirect:/main/admin/blog_admin";
    }


    @GetMapping("/main/admin/blog_admin/offers")
    public String offersToAdmin(Model model)
    {
        List<Post> listPost=postService.listAll();
        model.addAttribute("listPost",listPost);
        return "offers_to_admin";
    }

    @GetMapping("/main/admin/blog_admin/offers/text/{id}")
    public ModelAndView readOffers(@PathVariable(name = "id") int id)
    {
        ModelAndView mav=new ModelAndView("read_offers_page");
        Post post=postService.get(id);
        mav.addObject(post);
        return mav;

    }

    //EDIT
    @GetMapping("/main/admin/blog_admin/offers/edit/{id}")
    public ModelAndView editOfferPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_offer");
        Post post=postService.get(id);
        mav.addObject("post",post);

        return mav;
    }

    @PostMapping(value = "/main/admin/blog_admin/offers/edit/save")
    public String saveEditedOffer(@ModelAttribute("post") Post post)
    {
        postService.save(post);
        return "redirect:/main/admin/blog_admin/offers";
    }

    //DELETE
    @GetMapping("/main/admin/blog_admin/offers/delete/{id}")
    public String deleteOffer(@PathVariable(name = "id") int id) {
        postService.delete(id);
        return "redirect:/main/admin/blog_admin/offers";
    }



    @GetMapping("/main/admin/blog_admin/offers/accept/{id}")
    public String acceptOffer(Model model,@PathVariable(name = "id") int id)
    {
        Post post=postService.get(id);
        Blog1 blog1=new Blog1();
        blog1.setTitle(post.getTitle());
        blog1.setContent(post.getContent());
        blog1.setUsername(post.getUsername());
        blog1.setCategory(post.getCategory());
        model.addAttribute("blog1",blog1);
        return "new_offer_text";

    }

    @PostMapping("/main/admin/blog_admin/offers/accept/save")
    public String acceptAndSaveOffer(@ModelAttribute("blog1") Blog1 blog1)
    {
        service.save(blog1);
        return "redirect:/main/admin/blog_admin";

    }

    //ADMIN PAGE
    @GetMapping("/main/admin")
    public String admin()
    {
        return "admin";
    }


    //READ
    @GetMapping("/main/admin/blog_admin/text/{id}")
    public ModelAndView read(@PathVariable(name = "id") int id)
    {
        ModelAndView mav=new ModelAndView("admin_read_page");
        Blog1 blog1=service.get(id);
        mav.addObject(blog1);
        return mav;

    }




    //Filter
    @PostMapping("/main/admin/blog_admin/filter")
    public String filterAdmin(@RequestParam String filter, Model model)
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
        return "index_for_admin";
    }

    //EDIT
    @GetMapping("/main/admin/blog_admin/edit/{id}")
    public ModelAndView showEditBlogPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_blog");
        Blog1 blog1 = service.get(id);
        mav.addObject("blog1",blog1);

        return mav;
    }

    //DELETE
    @GetMapping("/main/admin/blog_admin/delete/{id}")
    public String deleteBlog(@PathVariable(name = "id") int id) {
        creation.remove((long)id);
        service.delete(id);
        return "redirect:/main/admin/blog_admin";
    }

    //Get All Users
    @GetMapping("/main/admin/users")
    public String getAllUsers(Model model)
    {
        List<User> userList=userService.allUsers();
        model.addAttribute("userList",userList);
        return "user_list";

    }
    @GetMapping("/main/admin/users/this_user/{id}")
    public String thisUser(@PathVariable(name="id") int id,Model model)
    {
        User user=userService.findUserById(id);
        model.addAttribute("user",user);
        return "this_user";


    }

    @Autowired
    private SessionRegistry sessionRegistry;

    @GetMapping("/main/admin/active_users")
    public String listLoggedInUsers(Model model) {
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        List<User> userList=new ArrayList<>();
        for(Object o:allPrincipals)
        {
            userList.add((User) o);
        }
        model.addAttribute("userList",userList);
        return "active_users";

    }

    //FILTER
    @PostMapping("/main/admin/users/filter")
    public String filter(@RequestParam String filter, Model model)
    {
        List<User> userList=new ArrayList<User>();


        if(filter!=null&&!filter.isEmpty())
        {
            if (userService.findByUsername(filter)==null)
            {
                model.addAttribute("userList",userList);
                return "user_list";
            }
            userList.add(userService.findByUsername(filter));
        }
        else
        {
            userList=userService.allUsers();
        }

        model.addAttribute("userList", userList);
        return "user_list";

    }



}
