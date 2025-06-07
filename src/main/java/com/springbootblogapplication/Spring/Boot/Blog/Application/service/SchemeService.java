package com.springbootblogapplication.Spring.Boot.Blog.Application.service;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.SchemeData;

import java.util.List;

public interface SchemeService {
    void createSchemeData(SchemeData schemeData);

    List<SchemeData> getAllSchemeData();

    SchemeData getSchemeData(String schemeName);

    SchemeData deleteSchemeData(String schemeName);
}
