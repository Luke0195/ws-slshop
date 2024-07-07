package br.com.barbershop.bunisses.exceptions;

public class InvalidParamException extends RuntimeException {

    public InvalidParamException(String message){
        super(message);
    }
}
