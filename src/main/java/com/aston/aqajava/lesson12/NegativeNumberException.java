package com.aston.aqajava.lesson12;

public class NegativeNumberException extends RuntimeException{
    public NegativeNumberException(){
        super();
    }
    public NegativeNumberException(String message){
        super(message);
    }
}
