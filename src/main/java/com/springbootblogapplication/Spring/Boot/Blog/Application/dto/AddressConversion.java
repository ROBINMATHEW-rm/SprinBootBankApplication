package com.springbootblogapplication.Spring.Boot.Blog.Application.dto;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AddressDto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressConversion {
public Address dtoToEntity(AddressDto addressDto){
    Address address = new Address();
    address.setStreet(addressDto.getStreet());
    address.setState(addressDto.getState());
    address.setZipCode(addressDto.getZipCode());
    return address;
}
    public AddressDto entityToDto(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setStreet(address.getStreet());
        addressDto.setState(address.getState());
        addressDto.setZipCode(address.getZipCode());
        return addressDto;
    }
}
