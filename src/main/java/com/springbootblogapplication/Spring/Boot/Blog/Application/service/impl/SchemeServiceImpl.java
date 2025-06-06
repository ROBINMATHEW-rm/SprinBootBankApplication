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

    public SchemeServiceImpl(SchemeDao schemeDao, SchemeAssembler schemeAssembler) {
        this.schemeDao = schemeDao;
        this.schemeAssembler = schemeAssembler;
    }
    @Override
    public void createSchemeData(SchemeData schemeData){
        schemeDao.createSchemeData(schemeAssembler.assembleCreateSchemeData(schemeData));
    }
    @Override
    public List<SchemeData> getAllSchemeData(){
        return schemeDao.getAllSchemeData();
    }
    @Override
    public SchemeData getSchemeData(String schemeName){
        return schemeDao.getSchemeData(schemeName);
    }
}

