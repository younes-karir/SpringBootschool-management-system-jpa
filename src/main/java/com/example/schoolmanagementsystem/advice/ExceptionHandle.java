package com.example.schoolmanagementsystem.advice;


import com.example.schoolmanagementsystem.advice.exceptions.ElementNotFoundException;
import com.example.schoolmanagementsystem.advice.exceptions.ExistedElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<Object> handleElementNotFoundException(Exception exception){

        AppException appException = new AppException(
                exception.getMessage(),
                HttpStatus.NOT_FOUND
        );
        return new ResponseEntity<>(appException,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ExistedElementException.class)
    public ResponseEntity<Object> handleExistedElementException(Exception exception){

        AppException appException = new AppException(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(appException,HttpStatus.BAD_REQUEST);
    }


}
