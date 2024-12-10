package com.example.Catalog_Management_System.Exceptions;

public class BrandNotAvailable extends RuntimeException{
    public BrandNotAvailable(String msg){
                   super(msg);
    }
}
