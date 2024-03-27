package com.demo.blog.controller;

import com.demo.blog.client.PostClient;
import com.demo.blog.model.Post;
import com.demo.blog.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostController {

    //private PostService postService;
    private final PostClient postClient;

    public PostController(PostClient postClient) {
        this.postClient = postClient;
    }

    @GetMapping("/posts")
    public List<Post> findAll() {
        return postClient.findAll();
    }

    @GetMapping("/posts/{id}")
    public Post findById(@PathVariable Integer id) {
        return postClient.findById(id);
    }

}
