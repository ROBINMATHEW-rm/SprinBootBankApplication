package com.springbootblogapplication.Spring.Boot.Blog.Application.query;

public class SchemeQuery {
    public static final String INSERT_SCHEME_DATA = "insert into SCHEME(NAME,DESCRIPTION) values(?,?);";
    public static final String GET_ALL_SCHEME_DATA = "select * from SCHEME";
}
