package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.SchemeData;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.SchemeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1")
public class SchemeController {
    private final SchemeService schemeService;

    public SchemeController(SchemeService schemeService) {
        this.schemeService = schemeService;
    }

    @PostMapping("/schema-data")
    public ResponseEntity<?> createScheme(@RequestBody SchemeData schemeData) {
        schemeService.createSchemeData(schemeData);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created Successfully");
    }
    @GetMapping("/schema-data")
    public ResponseEntity<?> getAllScheme(@RequestBody SchemeData schemeData) {
        List<SchemeData> response = schemeService.getAllSchemeData();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/schema-data/{schemeName}")
    public ResponseEntity<?> getScheme(@PathVariable String schemeName) {
        SchemeData response = schemeService.getSchemeData(schemeName);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @DeleteMapping("/schema-data/{schemeName}")
    public ResponseEntity<?> deleteScheme(@PathVariable String schemeName) {
        String response = schemeService.deleteSchemeData(schemeName);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
