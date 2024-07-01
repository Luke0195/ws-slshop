package br.com.barbershop.utils.http;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.barbershop.dto.response.HttpResponseDto;

public class HttpUtil {
  
  private HttpUtil(){};

  public static URI getUriFromRequest(Object object){
    return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(object).toUri();
  }

  public static HttpResponseDto makeHttpResponseDto(Integer status, Object body, Boolean success){
    return HttpResponseDto.builder().status(status).success(success).build();
  }
  public static<T, K> ResponseEntity<T> getCreatedResponse(T response, K objectId){
    URI uri = getUriFromRequest(objectId);
    return ResponseEntity.created(uri).body(response);
  }
}
