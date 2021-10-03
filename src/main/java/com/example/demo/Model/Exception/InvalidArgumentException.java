package com.example.demo.Model.Exception;


public class InvalidArgumentException extends RuntimeException {
    public InvalidArgumentException() {
        super("Vnesete argumenti");
    }
}