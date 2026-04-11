package com.example.User.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.User.entity.User;
import com.example.User.repository.UserRepo;

@Service
public class UserService {


    @Autowired
    private UserRepo repository;

    public User getUserById(int id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public User createUser(User user) {
        return repository.save(user);
    }
}
