package com.springbootblogapplication.Spring.Boot.Blog.Application.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private String timeStamp;
    private String message;
    private String details;
}
