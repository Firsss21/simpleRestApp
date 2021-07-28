package com.example.simplerestapp.exception;

public class UserNotExist extends Exception{
    public UserNotExist(String message) {
        super(message);
    }
}
