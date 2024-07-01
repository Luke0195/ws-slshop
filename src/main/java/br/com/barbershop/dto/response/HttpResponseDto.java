package br.com.barbershop.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpResponseDto implements Serializable {
  
  private Integer status;
  private Boolean success;
  private Object body;
}
