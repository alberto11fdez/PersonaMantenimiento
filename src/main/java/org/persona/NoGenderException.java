package org.persona;

public class NoGenderException extends RuntimeException{

    public NoGenderException(String errorMessage){
        super (errorMessage);
    }
}
