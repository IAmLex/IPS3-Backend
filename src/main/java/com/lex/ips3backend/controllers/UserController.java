package com.lex.ips3backend.controllers;

import com.lex.ips3backend.models.Comment;
import com.lex.ips3backend.models.Post;
import com.lex.ips3backend.models.User;
import com.lex.ips3backend.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public List<User> getAll() {
        return this.userService.getAll();
    }

    @GetMapping("/{userId}")
    public User getById(@PathVariable Integer userId) {
        return this.userService.getUser(userId);
    }

    @GetMapping("/{userId}/posts")
    public List<Post> getPosts(@PathVariable Integer userId) {
        return this.userService.getPosts(userId);
    }


    @PostMapping("")
    public void insert(@RequestBody User user) {
        this.userService.insert(user);
    }

}
