package com.lex.ips3backend.controllers;

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
    public List<User> GetAll() {
        return this.userService.GetAll();
    }

    @GetMapping("/{userId}/getPosts")
    public List<Post> GetPosts(@PathVariable Integer userId) {
        return this.userService.GetPosts(userId);
    }

    @PostMapping("")
    public void Insert(@RequestBody User user) {
        this.userService.Insert(user);
    }
}
