package com.springbootblogapplication.Spring.Boot.Blog.Application.service.impl;

import com.springbootblogapplication.Spring.Boot.Blog.Application.assembler.SchemeAssembler;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dao.SchemeDao;
import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.SchemeData;
import com.springbootblogapplication.Spring.Boot.Blog.Application.service.SchemeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchemeServiceImpl implements SchemeService {
    private final SchemeDao schemeDao;
    private final SchemeAssembler schemeAssembler;
    private final SchemeServiceImplValidation schemeServiceImplValidation;

    public SchemeServiceImpl(SchemeDao schemeDao, SchemeAssembler schemeAssembler, SchemeServiceImplValidation schemeServiceImplValidation) {
        this.schemeDao = schemeDao;
        this.schemeAssembler = schemeAssembler;
        this.schemeServiceImplValidation = schemeServiceImplValidation;
    }
    @Override
    public SchemeData createSchemeData(SchemeData schemeData){
        schemeServiceImplValidation.validateCreateSchemeDetails(schemeData);
        return schemeDao.createSchemeData(schemeAssembler.assembleCreateSchemeData(schemeData));
    }
    @Override
    public List<SchemeData> getAllSchemeData(){
        return schemeDao.getAllSchemeData();
    }
    @Override
    public SchemeData getSchemeData(String schemeName){
        return schemeDao.getSchemeData(schemeName);
    }
    @Override
    public String deleteSchemeData(String schemeName){
        return schemeDao.deleteSchemeData(schemeName);
    }
}

