package org.persona;

public class AgeNegativeException extends RuntimeException{

    public AgeNegativeException(String errorMessage){
        super (errorMessage);
    }
}
