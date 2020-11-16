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

    public List<User> getAll() {
        return this.userRepository.findAll();
    }

    public User getUser(Integer id) {
        return this.userRepository.findById(id).orElse(null);
    }

    public void insert(User user) {
        this.userRepository.save(user);
    }

    public List<Post> getPosts(Integer userId) {
        // TODO: Remove user from data
        return this.getUser(userId).getPosts();
    }

    public User getByEmailAndPassword(User user) {
        return this.userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());
    }
}
