package com.example.schoolmanagementsystem.advice.exceptions;

public class ExistedElementException extends RuntimeException{
    public ExistedElementException(String message) {
        super(message);
    }

    public ExistedElementException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExistedElementException(Throwable cause) {
        super(cause);
    }
}
