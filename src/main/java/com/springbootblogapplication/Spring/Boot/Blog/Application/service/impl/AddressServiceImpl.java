package com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl;

import com.springbootblogapplication.Spring.Boot.Blog.Application.constants.ApplicationConstants;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AddressDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.conversion.AddressConversion;
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
    @Autowired
    private AddressServiceImplValidation addressServiceImplValidation;
    @Override
    public AddressDto addressAdd(AddressDto addressDto){
    Address address=addressConversion.dtoToEntity(addressDto);
    addressServiceImplValidation.validateCreateAddressDetails(address);
    Address result = addressRepo.save(address);
    return addressConversion.entityToDto(result);
    }
    @Override
    public AddressDto addressUpdate(long id, AddressDto addressDto){
        Address result = addressRepo.findById(id).orElseThrow(() -> new DataNotFoundException(ApplicationConstants.NO_ADDRESS_DATA_FOUND_MESSAGE));
        result.setStreet(addressDto.getStreet());
        result.setState(addressDto.getState());
        result.setZipCode(addressDto.getZipCode());
        addressServiceImplValidation.validateUpdateAddressDetails(result);
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
        Address result = addressRepo.findById(id).orElseThrow(() -> new DataNotFoundException(ApplicationConstants.NO_ADDRESS_DATA_FOUND_MESSAGE));
        return addressConversion.entityToDto(result);
    }
    @Override
    public AddressDto removeAddress(long id){
        Address address = addressRepo.findById(id).orElseThrow(() -> new DataNotFoundException(ApplicationConstants.NO_ADDRESS_DATA_FOUND_MESSAGE));
        addressRepo.deleteById(id);
        return addressConversion.entityToDto(address);
    }
}
