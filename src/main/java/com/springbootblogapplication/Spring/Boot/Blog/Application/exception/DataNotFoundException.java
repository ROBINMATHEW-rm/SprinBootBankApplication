package com.springbootblogapplication.Spring.Boot.Blog.Application.exception;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String message){
        super(message);
    }
}

