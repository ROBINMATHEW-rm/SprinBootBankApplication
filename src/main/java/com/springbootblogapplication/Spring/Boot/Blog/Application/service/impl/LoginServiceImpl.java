package com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl;

import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.User;
import com.springbootblogapplication.Spring.Boot.Blog.Application.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoginServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(()->new UsernameNotFoundException("User Not Found"));
        Set<GrantedAuthority> authorities =user.getRoleSet().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toSet());
         return new org.springframework.security.core.userdetails.User(
                 user.getEmail(),
                 user.getPassword(),
                 authorities
         );
    }
}
