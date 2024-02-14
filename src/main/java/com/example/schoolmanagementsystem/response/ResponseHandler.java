package com.example.schoolmanagementsystem.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {




    public static ResponseEntity<Object> responseBuilder(
            String message,
            HttpStatus httpStatus,
            Object responseObject
    )
    {
        Map<String,Object> responses =  new HashMap<>();
        responses.put("message",message);
        responses.put("httpStatus" , httpStatus);
        responses.put("data",responseObject);
        return new ResponseEntity<>(responses,httpStatus);
    }
}
