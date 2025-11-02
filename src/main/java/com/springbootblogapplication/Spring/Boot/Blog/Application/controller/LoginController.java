package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.User;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
//    private final AuthenticationManager authenticationManager;
//    private final JwtUtils jwtUtils;
//    private final LoginServiceImpl loginService;
    @Autowired
    private AuthService authService;
//
//    public LoginController(LoginServiceImpl loginService) {
//        this.loginService = loginService;
//    }
//
//    @PostMapping("api/login")
//    public ResponseEntity<?> login(@RequestBody LoginDto loginDto){
//        authenticationManager.authenticate(
//            new UsernamePasswordAuthenticationToken(loginDto.getEmail(),loginDto.getPassword())
//        );
//        UserDetails userDetails = loginService.loadUserByUsername(loginDto.getEmail());
//        String token = jwtUtils.generateToken(userDetails);
//        return ResponseEntity.ok(new AuthResponse(token));
//    }
    @PostMapping("/user")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        User result = authService.userAdd(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
