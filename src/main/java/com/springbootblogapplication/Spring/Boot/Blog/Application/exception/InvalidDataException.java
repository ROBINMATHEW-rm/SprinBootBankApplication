package com.springbootblogapplication.Spring.Boot.Blog.Application.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
public class InvalidDataException extends RuntimeException {
    private final List<String> errors;
}
