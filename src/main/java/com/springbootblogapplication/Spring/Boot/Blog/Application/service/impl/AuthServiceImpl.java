//package com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl;
//
//import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.LoginDto;
//import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Role;
//import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.User;
//import com.springbootblogapplication.Spring.Boot.Blog.Application.exception.DataNotFoundException;
//import com.springbootblogapplication.Spring.Boot.Blog.Application.repository.RoleRepo;
//import com.springbootblogapplication.Spring.Boot.Blog.Application.repository.UserRepository;
//import com.springbootblogapplication.Spring.Boot.Blog.Application.service.AuthService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class AuthServiceImpl  implements AuthService{
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private RoleRepo roleRepo;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//    @Override
//    public User userAdd(User user){
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        Set<Role> roleSet = new HashSet<>();
//        Role userRole = roleRepo.findByName("ROLE_USER").get();
//        roleSet.add(userRole);
//        user.setRoleSet(roleSet);
//        User result = userRepository.save(user);
//        return user;
//    }
//}
