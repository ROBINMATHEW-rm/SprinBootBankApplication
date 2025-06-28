package com.springbootblogapplication.Spring.Boot.Blog.Application.service;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.LoginDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.User;

public interface AuthService {
    User userAdd(User user);

    User loadUserByNameAndEmail(String email, String password);
}
