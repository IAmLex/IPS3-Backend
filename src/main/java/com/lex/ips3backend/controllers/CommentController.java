package com.lex.ips3backend.controllers;

import com.lex.ips3backend.models.Comment;
import com.lex.ips3backend.models.Post;
import com.lex.ips3backend.models.User;
import com.lex.ips3backend.services.CommentService;
import com.lex.ips3backend.services.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentService _commentService;

    public CommentController(CommentService commentService) {
        this._commentService = commentService;
    }

    @GetMapping("")
    public List<Comment> getAll() {
        return this._commentService.getAll();
    }

    @PostMapping("")
    public void insert(@RequestBody Comment comment) {
        this._commentService.insert(comment);
    }

    @GetMapping("/{commentId}")
    public Comment getCommentById(@PathVariable Integer commentId) {
        return this._commentService.getById(commentId);
    }

    @GetMapping("/{commentId}/user")
    public User getUser(@PathVariable Integer commentId) {
        return this._commentService.getById(commentId).getUser();
    }
}
