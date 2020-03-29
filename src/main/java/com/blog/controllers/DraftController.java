package com.blog.controllers;


import com.blog.entities.Blog1;
import com.blog.entities.Draft;
import com.blog.entities.Post;
import com.blog.entities.User;
import com.blog.services.DraftService;
import com.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DraftController {
    @Autowired
    DraftService draftService;




    @GetMapping("/blog/draft")
    public String drafts(Model model) {
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Draft> listDraft = draftService.draftgtList(user.getUsername());
        model.addAttribute("listDraft",listDraft);

        return "draft_page";
    }

    @GetMapping("/blog/draft/new")
    public String new_draft(Model model)
    {
        Draft draft =new Draft();
        model.addAttribute("draft",draft);
        return "save_draft";
    }

    @PostMapping(value = "/blog/draft/save")
    public String saveProduct(@ModelAttribute("draft") Draft draft) {
        User user= (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        draft.setUsername(user.getUsername());
        draftService.save(draft);

        return "redirect:/blog/draft";
    }

    @GetMapping("/blog/draft/text/{id}")
    public ModelAndView read(@PathVariable(name = "id") int id)
    {
        ModelAndView mav=new ModelAndView("draft_reader");
        Draft draft=draftService.get(id);
        mav.addObject(draft);
        return mav;

    }

    //EDIT
    @GetMapping("/blog/draft/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("draft_editor");
        Draft draft = draftService.get(id);
        mav.addObject("draft",draft);

        return mav;
    }

    //DELETE
    @GetMapping("/blog/draft/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        draftService.delete(id);
        return "redirect:/blog/draft";
    }

    @GetMapping("/blog/draft/post/{id}")
    public String offerDraft(Model model,@PathVariable(name = "id") int id)
    {
        Draft draft=draftService.get(id);
        Post post=new Post();
        post.setTitle(draft.getTitle());
        post.setCategory(draft.getCategory());
        post.setContent(draft.getContent());
        post.setUsername(draft.getUsername());
        model.addAttribute("post",post);
        return "user_offer";

    }

}
