package com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl;

import com.springbootblogapplication.Spring.Boot.Blog.Application.constants.ApplicationConstants;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Address;
import com.springbootblogapplication.Spring.Boot.Blog.Application.exception.InvalidDataException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImplValidation {
    public void validateCreateAddressDetails(Address address){
        List<String> fieldsName=new ArrayList<>();
        String street = address.getStreet();
        String state  = address.getState();
        String zipCode = address.getZipCode();
        if(StringUtils.isEmpty(street)){
            fieldsName.add(ApplicationConstants.NULL_VALUE_STREET_NAME);
        }
        if(StringUtils.isEmpty(state)){
            fieldsName.add(ApplicationConstants.NULL_VALUE_STATE_NAME);
        }
        if(StringUtils.isEmpty(zipCode)){
            fieldsName.add(ApplicationConstants.NULL_VALUE_ZIP_CODE);
        }
        if(!fieldsName.isEmpty()){
           throw new InvalidDataException(fieldsName);
        }
    }
    public void validateUpdateAddressDetails(Address address){
        List<String> fieldsName=new ArrayList<>();
        String street = address.getStreet();
        String state  = address.getState();
        String zipCode = address.getZipCode();
        if(StringUtils.isEmpty(street)){
            fieldsName.add(ApplicationConstants.NULL_VALUE_STREET_NAME);
        }
        if(StringUtils.isEmpty(state)){
            fieldsName.add(ApplicationConstants.NULL_VALUE_STATE_NAME);
        }
        if(StringUtils.isEmpty(zipCode)){
            fieldsName.add(ApplicationConstants.NULL_VALUE_ZIP_CODE);
        }
        if(!fieldsName.isEmpty()){
            throw new InvalidDataException(fieldsName);
        }
    }
}
