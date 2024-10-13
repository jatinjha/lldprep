package com.jatin.execeptions;

public class NameAlreadyExistsException extends RuntimeException{
    public NameAlreadyExistsException(String message){
        super(message);
    }
}
