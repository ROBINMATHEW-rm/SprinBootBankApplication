package com.springbootblogapplication.Spring.Boot.Blog.Application.service;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.AddressDto;

import java.util.List;

public interface AddressService {
    AddressDto addressAdd(AddressDto addressDto);

    AddressDto addressUpdate(long id, AddressDto addressDto);

    List<AddressDto> addressGetAll();

    AddressDto addressGetSingle(long id);

    AddressDto removeAddress(long id);
}
