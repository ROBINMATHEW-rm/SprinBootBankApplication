package com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl;

import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.User;
import com.springbootblogapplication.Spring.Boot.Blog.Application.repository.UserRepository;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User userAdd(User user){
        User result = userRepository.save(user);
        return result;
    }
}
