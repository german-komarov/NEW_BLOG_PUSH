package com.blog.controllers;


import com.blog.entities.Blog1;
import com.blog.entities.Post;
import com.blog.entities.Role;
import com.blog.entities.Users;
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

import java.util.*;

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
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        blog1.setUsername(users.getUsername());
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
    public String admin(Model model)
    {
        Users users = (Users) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Set<Role> roleSet= users.getRoles();
        for (Role role:roleSet)
        {
            if (role.getName().equals("ROLE_ADMIN"))
            {
                model.addAttribute("role","admin");
                break;
            }
        }
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
            listBlog1=service.findByCategoryModified(filter);
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
        List<Users> usersList =userService.allUsers();
        model.addAttribute("usersList", usersList);
        return "user_list";

    }
    @GetMapping("/main/admin/users/this_user/{id}")
    public String thisUser(@PathVariable(name="id") int id,Model model)
    {
        Users users =userService.findUserById(id);

        model.addAttribute("users", users);

        return "this_user";


    }

    @GetMapping("/main/admin_special/users/make_moderator/{id}")
    public String makeFromUserAdmin(@PathVariable("id") long id)
    {
        userService.makeModerator(id);
        return "redirect:/main/admin_special/users";
    }

    @GetMapping("/main/admin_special/users/delete_moderator/{id}")
    public String deleteAdmin(@PathVariable("id") long id)
    {
        userService.deleteModerator(id);
        return "redirect:/main/admin_special/users";
    }

    @GetMapping("/main/admin_special/users")
    public String adminWithOptions(Model model)
    {
        List<Users> usersList=userService.allUsers();
        model.addAttribute("usersList",usersList);
        return "users_with_options";
    }


    @Autowired
    private SessionRegistry sessionRegistry;

    @GetMapping("/main/admin/active_users")
    public String listLoggedInUsers(Model model) {
        List<Object> allPrincipals = sessionRegistry.getAllPrincipals();
        List<Users> usersList =new ArrayList<>();
        for(Object o:allPrincipals)
        {
            usersList.add((Users) o);
        }
        model.addAttribute("usersList", usersList);
        return "active_users";

    }

    //FILTER
    @PostMapping("/main/admin/users/filter")
    public String filter(@RequestParam String filter, Model model)
    {
        List<Users> usersList =new ArrayList<Users>();


        if(filter!=null&&!filter.isEmpty())
        {
            if (userService.findByUsername(filter)==null)
            {
                model.addAttribute("usersList", usersList);
                return "user_list";
            }
            usersList.add(userService.findByUsername(filter));
        }
        else
        {
            usersList =userService.allUsers();
        }

        model.addAttribute("usersList", usersList);
        return "user_list";

    }



}
