package br.com.barbershop.utils.presenter;

public class PresenterHelper {

  private PresenterHelper(){};

  public static String getInvalidFieldException(String domainContext, String fieldName){
    return String.format("This %s %s already exists!", domainContext, fieldName);
  }
  
}
