package org.persona;

public class NameEmptyException extends RuntimeException{

    public NameEmptyException(String errorMessage){
        super (errorMessage);
    }
}
