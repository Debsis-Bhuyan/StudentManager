package com.debasis.sp_demo.exception;

public class StudentAlreadyExistException extends RuntimeException {
    public StudentAlreadyExistException(String message) {
        super(message);
    }
}
