package com.springbootblogapplication.Spring.Boot.Blog.Application.query;

public class SchemeQuery {
    public static final String INSERT_SCHEME_DATA = "insert into SCHEME(NAME,DESCRIPTION) values(?,?);";
    public static final String GET_ALL_SCHEME_DATA = "select * from SCHEME";
    public static final String GET_SCHEME_DATA = "select * from SCHEME where NAME=?";
    public static final String GET_SCHEME_ROW_DATA = "select COUNT(*) as numRows from SCHEME where NAME=?";
    public static final String DELETE_SCHEME_DATA = "delete from SCHEME where NAME=?";
}
