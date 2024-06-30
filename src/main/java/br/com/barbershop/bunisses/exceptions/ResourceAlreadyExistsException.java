package br.com.barbershop.bunisses.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException{

  public ResourceAlreadyExistsException(String message){
    super(message);
  }
}
