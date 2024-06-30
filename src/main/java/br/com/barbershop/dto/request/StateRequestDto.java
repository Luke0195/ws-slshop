package br.com.barbershop.dto.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StateRequestDto implements Serializable{

  @NotEmpty(message = "The field name is required")
  private String name;
  @NotEmpty(message = "The field uf is required")
  private String uf;
  
}
