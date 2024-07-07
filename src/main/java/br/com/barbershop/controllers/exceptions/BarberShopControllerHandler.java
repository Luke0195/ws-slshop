package br.com.barbershop.controllers.exceptions;

import java.time.Instant;
import java.util.ArrayList;

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
    StandardResponseDto standardResponseDto = 
    StandardResponseDto.builder()
    .timestamp(Instant.now())
    .status(HttpStatus.BAD_REQUEST.value())
    .path(httpServletRequest.getRequestURI())
    .errors(new ArrayList<>())
    .error("Resource already exists")
    .exceptionMessage(exception.getMessage()).build();
    return HttpUtil.getBadRquest(standardResponseDto);
  }

  @ExceptionHandler(InvalidParamException.class)
  public ResponseEntity<StandardResponseDto> invalidParam(HttpServletRequest httpServletRequest, InvalidParamException invalidParamException){
    StandardResponseDto standardResponseDto = StandardResponseDto
            .builder()
            .timestamp(Instant.now())
            .status(HttpStatus.BAD_REQUEST.value())
            .path(httpServletRequest.getRequestURI()).error("Receive invalid param").exceptionMessage(invalidParamException.getMessage()).build();
   return HttpUtil.getBadRquest(standardResponseDto);
  }
  
}
