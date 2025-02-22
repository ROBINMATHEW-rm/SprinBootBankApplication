package com.springbootblogapplication.Spring.Boot.Blog.Application.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddressDto {
    private long addressId;
    private String street;
    private String state;
    private String zipCode;
}
