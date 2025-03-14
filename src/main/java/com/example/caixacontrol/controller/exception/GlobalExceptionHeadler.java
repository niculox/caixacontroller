package com.example.caixacontrol.controller.exception;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHeadler {
    
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        return new Response();
    }

}
