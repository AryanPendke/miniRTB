package com.aryan.MiniRTB.exception;

public class AdvertiserAlreadyExistsException extends RuntimeException {
    
    public AdvertiserAlreadyExistsException(String name){
        super("Advertiser '%s' already exists".formatted(name));
    }
}
