package com.beta.BRD_ProductService.exception;

public class ProductInsufficientQuantityException extends RuntimeException{

    public ProductInsufficientQuantityException(String message) {
        super(message);
    }
}
