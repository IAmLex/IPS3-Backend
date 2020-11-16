package com.lex.ips3backend.controllers;

import com.lex.ips3backend.models.Post;
import com.lex.ips3backend.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("")
    public List<Post> GetAll() {
        return this.postService.GetAll();
    }

    @GetMapping("/{postId}")
    public Post getById(@PathVariable Integer postId) {
        return this.postService.getById(postId);
    }

    @PostMapping("")
    public void Insert(@RequestBody Post post) {
        this.postService.Insert(post);
    }
}
