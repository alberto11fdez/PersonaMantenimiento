package org.persona;

public class GenderEmptyException extends RuntimeException{

    public GenderEmptyException(String errorMessage){
        super (errorMessage);
    }
}
