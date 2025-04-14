package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.LoginDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.User;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody User user){
        String result = authService.userAdd(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @PostMapping(value = "/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginDto loginDto){
        String result = authService.login(loginDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
