package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AddressDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequestMapping("v1")
@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;
    @PostMapping("/address")
    public ResponseEntity<?> addressAdd(@RequestBody AddressDto addressDto){
        AddressDto result=addressService.addressAdd(addressDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
