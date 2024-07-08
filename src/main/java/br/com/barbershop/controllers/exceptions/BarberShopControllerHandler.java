package br.com.barbershop.controllers.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import br.com.barbershop.bunisses.exceptions.InvalidParamException;
import br.com.barbershop.utils.http.HttpUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.barbershop.bunisses.exceptions.ResourceAlreadyExistsException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class BarberShopControllerHandler {


  @ExceptionHandler(ResourceAlreadyExistsException.class)
  public ResponseEntity<StandardResponseDto> entityAlreadyExists(HttpServletRequest httpServletRequest, ResourceAlreadyExistsException exception){
    return HttpUtil.getBadRquest(makeStandardResponseDto(HttpUtil.getURIPath(httpServletRequest), HttpStatus.BAD_REQUEST.value(), "Resource already exists!", exception.getMessage(), new ArrayList<>()));
  }

  @ExceptionHandler(InvalidParamException.class)
  public ResponseEntity<StandardResponseDto> invalidParam(HttpServletRequest httpServletRequest, InvalidParamException invalidParamException){
   return HttpUtil.getBadRquest(makeStandardResponseDto(HttpUtil.getURIPath(httpServletRequest), HttpStatus.BAD_REQUEST.value() , "Receive invalid param", invalidParamException.getMessage(), new ArrayList<>()));
  }

  private static StandardResponseDto makeStandardResponseDto(String path, int status, String error, String exceptionError, List<Object> errorList){
    return StandardResponseDto.builder().path(path).timestamp(Instant.now()).status(status).error(error).exceptionMessage(exceptionError).errors(errorList).build();
  }
  
}
