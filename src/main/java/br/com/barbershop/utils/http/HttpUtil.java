package br.com.barbershop.utils.http;

import java.net.URI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class HttpUtil {
  
  private HttpUtil(){}

  public static URI getUriFromRequest(Object object){
    return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(object).toUri();
  }


  public static<T, K> ResponseEntity<T> getCreatedResponse(T response, K objectId){
    URI uri = getUriFromRequest(objectId);
    return ResponseEntity.created(uri).body(response);
  }

  public static<T> ResponseEntity<T> getOkResponse(T response){
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  public static<T> ResponseEntity<T> getBadRquest(T response){
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
  }
}
