package com.springbootblogapplication.Spring.Boot.Blog.Application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    public final ResponseEntity<ErrorDetails> handleDataNotFoundException(DataNotFoundException ex, WebRequest webRequest){
        String timeStamp= LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        HttpStatus status =HttpStatus.NOT_FOUND;
        String detailedMessage =ex.getMessage();

        ErrorDetails errorDetails =new ErrorDetails(timeStamp,detailedMessage, webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails,status);
    }
    @ExceptionHandler(InvalidDataException.class)
    public final ResponseEntity<ErrorDetails> handleInvalidException(InvalidDataException ex, WebRequest webRequest){
        String timeStamp= LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        HttpStatus status =HttpStatus.UNPROCESSABLE_ENTITY;
        String detailedMessage = ex.getErrors().stream()
                .map(error -> String.format("\"%s\"",error))
                .collect(Collectors.joining(",","[","]"));

        ErrorDetails errorDetails =new ErrorDetails(timeStamp,detailedMessage, webRequest.getDescription(false));
        return new ResponseEntity<>(errorDetails,status);
    }

}
