package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;

import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.User;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/user")
    public ResponseEntity<?> roleAdd(@RequestBody User user){
        String result = userService.userAdd(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
