package com.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.security.entity.User;
import com.security.repositorie.UserRepositorie;

@Service
public class UserService {
    private final UserRepositorie userRepositorie;

    @Autowired
    public UserService(UserRepositorie userRepositorie) {
        this.userRepositorie = userRepositorie;
    }
    
    public User create(User user) {
        return userRepositorie.save(user);
    }
}
