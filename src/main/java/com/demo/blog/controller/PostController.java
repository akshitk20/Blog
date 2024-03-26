package com.demo.blog.controller;

import com.demo.blog.model.Post;
import com.demo.blog.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/posts")
    public List<Post> findAll() {
        return postService.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post findById(@PathVariable Integer id) {
        return postService.findById(id);
    }

}
