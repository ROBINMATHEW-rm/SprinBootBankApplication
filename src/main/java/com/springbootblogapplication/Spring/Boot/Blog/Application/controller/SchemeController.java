package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.SchemeData;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.SchemeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1")
public class SchemeController {
    private final SchemeService schemeService;

    public SchemeController(SchemeService schemeService) {
        this.schemeService = schemeService;
    }

    @PostMapping("/schema-data")
    public ResponseEntity<?> registerUser(@RequestBody SchemeData schemeData) {
        schemeService.createSchemeData(schemeData);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created Successfully");
    }
}
