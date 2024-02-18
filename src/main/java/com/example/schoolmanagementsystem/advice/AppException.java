package com.example.schoolmanagementsystem.advice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;



@AllArgsConstructor
public class AppException {

    @Getter
    private final String message;
    @Getter
    private final HttpStatus httpStatus;}
