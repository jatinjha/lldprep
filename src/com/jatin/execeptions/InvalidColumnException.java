package com.jatin.execeptions;

public class InvalidColumnException extends RuntimeException{
    public InvalidColumnException(String message){
        super(message);
    }
}
