package com.lex.ips3backend.controllers;

import com.lex.ips3backend.models.Comment;
import com.lex.ips3backend.models.Post;
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
}
