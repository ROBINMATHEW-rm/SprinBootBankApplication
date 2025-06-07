package com.springbootblogapplication.Spring.Boot.Blog.Application.dao;

import com.springbootblogapplication.Spring.Boot.Blog.Application.dto.SchemeData;

import java.util.List;

public interface SchemeDao {
    SchemeData createSchemeData(SchemeData schemeData);

    List<SchemeData> getAllSchemeData();

    SchemeData getSchemeData(String schemeName);

    String deleteSchemeData(String schemeName);
}
