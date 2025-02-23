package com.springbootblogapplication.Spring.Boot.Blog.Application.controller;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AddressDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/address/{id}")
    public ResponseEntity<?> getAddress(@PathVariable long id){
        AddressDto result=addressService.addressGetSingle(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @GetMapping("/address")
    public ResponseEntity<?> getAllAddress(){
        List<AddressDto> result=addressService.addressGetAll();
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
    @DeleteMapping("/address/{id}")
    public ResponseEntity<?> getRemoveAddress(@PathVariable long id){
        AddressDto result=addressService.removeAddress(id);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

}
