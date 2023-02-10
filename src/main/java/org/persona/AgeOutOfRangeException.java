package org.persona;

public class AgeOutOfRangeException extends RuntimeException{

    public AgeOutOfRangeException(String errorMessage){
        super (errorMessage);
    }
}
