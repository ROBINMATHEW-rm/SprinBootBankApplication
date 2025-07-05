package com.springbootblogapplication.Spring.Boot.Blog.Application.jwt;

import com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl.LoginServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private LoginServiceImpl loginService;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        // Skip JWT validation for public endpoints
        String path = request.getRequestURI();
        if (path.equals("/login") || path.equals("/user")) {
            filterChain.doFilter(request, response);
            return;
        }
         String authHeader = request.getHeader("Authorization");
         String token =null;
         String email =null;

         if(authHeader !=null && authHeader.startsWith("Bearer")){
             token =authHeader.substring(7);
             email =jwtUtils.extractEmail(token);
         }

         if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
               User useDetails = (User) loginService.loadUserByUsername(email);
               if(jwtUtils.validateToken(token)){
                   UsernamePasswordAuthenticationToken authenticationToken =
                           new UsernamePasswordAuthenticationToken(useDetails,null,useDetails.getAuthorities());
                   SecurityContextHolder.getContext().setAuthentication(authenticationToken);
               }
         }
         filterChain.doFilter(request,response);
    }
}
