package com.springbootblogapplication.Spring.Boot.Blog.Application.service;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.LoginDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.User;

public interface AuthService {
    String userAdd(User user);
}
