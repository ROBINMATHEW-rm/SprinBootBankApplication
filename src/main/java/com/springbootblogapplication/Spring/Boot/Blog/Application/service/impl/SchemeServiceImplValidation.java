package com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl;

import com.springbootblogapplication.Spring.Boot.Blog.Application.constants.ApplicationConstants;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.SchemeData;
import com.springbootblogapplication.Spring.Boot.Blog.Application.entity.Address;
import com.springbootblogapplication.Spring.Boot.Blog.Application.exception.InvalidDataException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
@Service
public class SchemeServiceImplValidation {
    public void validateCreateSchemeDetails(SchemeData schemeData){
        List<String> fieldsName = new ArrayList<>();
        String schemeName = schemeData.getSchemeName();
        String schemeDsc  = schemeData.getDescription();
        if(StringUtils.isEmpty(schemeName)){
            fieldsName.add(ApplicationConstants.SCHEME_NAME);
        }
        if(StringUtils.isEmpty(schemeDsc)){
            fieldsName.add(ApplicationConstants.SCHEME_DESC);
        }
        if(!fieldsName.isEmpty()){
            throw new InvalidDataException(fieldsName);
        }
    }
    public void validateUpdateSchemeDetails(SchemeData schemeData){
        List<String> fieldsName = new ArrayList<>();
        String schemeName = schemeData.getSchemeName();
        String schemeDsc  = schemeData.getDescription();
        if(StringUtils.isEmpty(schemeName)){
            fieldsName.add(ApplicationConstants.SCHEME_NAME);
        }
        if(StringUtils.isEmpty(schemeDsc)){
            fieldsName.add(ApplicationConstants.SCHEME_DESC);
        }
        if(!fieldsName.isEmpty()){
            throw new InvalidDataException(fieldsName);
        }
    }
}
