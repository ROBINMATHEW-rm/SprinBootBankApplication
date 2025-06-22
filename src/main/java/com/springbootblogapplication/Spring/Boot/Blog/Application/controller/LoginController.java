package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AddressDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AuthResponse;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.LoginDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.jwt.JwtUtils;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl.LoginServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("v1")
@RestController
public class LoginController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final LoginServiceImpl loginService;

    public LoginController(AuthenticationManager authenticationManager, JwtUtils jwtUtils, LoginServiceImpl loginService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
        authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
        );
        UserDetails userDetails = loginService.loadUserByUsername(loginDto.getEmail());
        String token = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new AuthResponse(token));
    }
}
