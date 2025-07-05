//package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;
//
//import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.User;
//import com.springbootblogapplication.Spring.Boot.Blog.Application.service.AuthService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class AuthController {
//
//    private final AuthService authService;
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @PostMapping("/user")
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        User result = authService.userAdd(user);
//        return ResponseEntity.status(HttpStatus.CREATED).body(result);
//    }
//}
