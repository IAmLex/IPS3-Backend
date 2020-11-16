package com.lex.ips3backend.services;

import com.lex.ips3backend.models.Comment;
import com.lex.ips3backend.models.Post;
import com.lex.ips3backend.repositories.ICommentRepository;
import com.lex.ips3backend.repositories.IPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    private final ICommentRepository _commentRepository;

    public CommentService(ICommentRepository commentRepository) {
        this._commentRepository = commentRepository;
    }

    public List<Comment> getAll() {
        return this._commentRepository.findAll();
    }

    public void insert(Comment comment) {
        this._commentRepository.save(comment);
    }
}
