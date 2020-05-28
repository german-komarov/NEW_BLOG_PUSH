package com.blog.controllers.rest;

import com.blog.entities.Blog1;
import com.blog.services.Blog1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
public class TestRest {
    @Autowired
    private Blog1Service service;


    @GetMapping("{topic}")
    public String allBlogs(@PathVariable("topic") String topic )
    {
        return topic;
    }






}
