package com.springbootblogapplication.Spring.Boot.Blog.Application.dto;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Address;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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
        addressDto.setAddressId(address.getId());
        addressDto.setStreet(address.getStreet());
        addressDto.setState(address.getState());
        addressDto.setZipCode(address.getZipCode());
        return addressDto;
    }
    public List<AddressDto> toDtoList(List<Address> addresses){
     return addresses.stream().map(this::entityToDto).collect(Collectors.toList());
    }
}
