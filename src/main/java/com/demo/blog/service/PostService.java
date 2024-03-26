package com.demo.blog.service;

import com.demo.blog.model.Post;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class PostService {
    private final List<Post> posts;

    private RestClient restClient;
    public PostService(RestClient restClient) {
        this.posts = List.of(new Post(1,1,"Hello world","This is my first post"));
        this.restClient = restClient;
    }
    public List<Post> findAll() {
        return restClient.get()
                .uri("/posts")
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    public Post findById(Integer id) {
        return restClient.get()
                .uri("/posts/{id}", id)
                .retrieve()
                .body(Post.class);
    }
}
