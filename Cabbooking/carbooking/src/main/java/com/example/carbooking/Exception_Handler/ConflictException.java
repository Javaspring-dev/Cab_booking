package com.example.carbooking.Exception_Handler;

public class ConflictException extends RuntimeException{
    public ConflictException(String message){
        super(message);
    }
}
