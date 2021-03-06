package com.lex.ips3backend.services;

import com.lex.ips3backend.models.Post;
import com.lex.ips3backend.repositories.IPostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    IPostRepository postRepository;

    public PostService(IPostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> GetAll() {
        return this.postRepository.findAllByOrderByCreatedAtDesc();
    }

    public void Insert(Post post) {
        this.postRepository.save(post);
    }

    public Post getById(Integer postId) {
        return this.postRepository.findById(postId).orElse(null);
    }
}
