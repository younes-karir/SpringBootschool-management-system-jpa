package com.example.schoolmanagementsystem.exception;


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ExceptionHandle {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleException(MethodArgumentNotValidException exceptions){
        Map<String,String> errors = new HashMap<>();
        exceptions.getBindingResult().getFieldErrors().forEach(
                item -> errors.put(item.getField(),item.getDefaultMessage())
        );
        return errors;
    }


}
