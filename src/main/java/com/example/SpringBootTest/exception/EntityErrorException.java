package com.example.SpringBootTest.exception;

public class EntityErrorException extends RuntimeException{
    public EntityErrorException(String message) {
        super(message);
    }
}
