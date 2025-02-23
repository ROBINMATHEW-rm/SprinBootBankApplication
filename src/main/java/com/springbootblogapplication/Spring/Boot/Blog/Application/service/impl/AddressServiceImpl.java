package com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AddressDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AddressConversion;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Address;
import com.springbootblogapplication.Spring.Boot.Blog.Application.repository.AddressRepo;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private AddressConversion addressConversion;
    @Override
    public AddressDto addressAdd(AddressDto addressDto){
    Address address=addressConversion.dtoToEntity(addressDto);
    Address result = addressRepo.save(address);
    return addressConversion.entityToDto(result);
    }
    @Override
    public List<AddressDto> addressGetAll(){
        List<Address> result = addressRepo.findAll();
        return addressConversion.toDtoList(result);
    }
    @Override
    public AddressDto addressGetSingle(long id){
        Address result = addressRepo.findById(id).orElseThrow(() -> new RuntimeException());
        return addressConversion.entityToDto(result);
    }
    @Override
    public AddressDto removeAddress(long id){
        Address address = addressRepo.findById(id).orElseThrow(() -> new RuntimeException());
        addressRepo.deleteById(id);
        return addressConversion.entityToDto(address);
    }
}
