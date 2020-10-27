package com.lex.ips3backend.services;

import com.lex.ips3backend.models.Post;
import com.lex.ips3backend.models.User;
import com.lex.ips3backend.repositories.IUserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UserService {
    IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> GetAll() {
        return this.userRepository.findAll();
    }

    public User SelectUser(Integer id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public void Insert(User user) {
        this.userRepository.save(user);
    }

    public List<Post> GetPosts(Integer userId) {
        // TODO: Remove user from data
        return this.SelectUser(userId).getPosts();
    }
}
