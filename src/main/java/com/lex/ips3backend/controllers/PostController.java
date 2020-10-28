package com.lex.ips3backend.controllers;

import com.lex.ips3backend.models.Post;
import com.lex.ips3backend.models.User;
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

    @PostMapping("/content/{content}/caption/{caption}/userId/{userId}")
    public void Insert(@PathVariable String content, @PathVariable String caption, @PathVariable Integer userId) {
        // FIXME: Make request body
        User user = new User(userId);
        Post post = new Post(content, caption, user);

        this.postService.Insert(post);
    }
}
