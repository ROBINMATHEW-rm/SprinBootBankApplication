package com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl;

import com.springbootblogapplication.Spring.Boot.Blog.Application.constants.ApplicationConstants;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AddressDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AddressConversion;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Address;
import com.springbootblogapplication.Spring.Boot.Blog.Application.exception.DataNotFoundException;
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
    public AddressDto addressUpdate(long id, AddressDto addressDto){
        Address result = addressRepo.findById(id).orElseThrow(() -> new RuntimeException());
        result.setStreet(addressDto.getStreet());
        result.setState(addressDto.getState());
        result.setZipCode(addressDto.getZipCode());
        Address updatedResult=addressRepo.save(result);
        return addressConversion.entityToDto(updatedResult);
    }
    @Override
    public List<AddressDto> addressGetAll(){
        List<Address> result = addressRepo.findAll();
        return addressConversion.toDtoList(result);
    }
    @Override
    public AddressDto addressGetSingle(long id){
        Address result = addressRepo.findById(id).orElseThrow(() -> new DataNotFoundException(ApplicationConstants.No_Address_Data_Found_Message));
        return addressConversion.entityToDto(result);
    }
    @Override
    public AddressDto removeAddress(long id){
        Address address = addressRepo.findById(id).orElseThrow(() -> new DataNotFoundException(ApplicationConstants.No_Address_Data_Found_Message));
        addressRepo.deleteById(id);
        return addressConversion.entityToDto(address);
    }
}
