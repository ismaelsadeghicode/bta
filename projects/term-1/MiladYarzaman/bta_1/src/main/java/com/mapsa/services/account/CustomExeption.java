package com.mapsa.services.account;

public class CustomExeption extends IllegalArgumentException{
    public CustomExeption(String errorMessage){
        super(errorMessage);
    }
}
