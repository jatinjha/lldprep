package com.jatin.execeptions;

public class DataBaseDoesNotExistException extends RuntimeException{
    public DataBaseDoesNotExistException(String message){
        super(message);
    }
}
