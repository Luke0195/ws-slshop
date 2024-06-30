package br.com.barbershop.utils.http;

import java.net.URI;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class HttpUtil {
  
  private HttpUtil(){};

  public static URI getUriFromRequest(Object object){
    return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(object).toUri();
  }
}
