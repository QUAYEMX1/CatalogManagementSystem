package com.example.Catalog_Management_System.Exceptions;

public class InvalidProductId extends RuntimeException{

    public InvalidProductId(String msg){
                           super(msg);
    }
}
