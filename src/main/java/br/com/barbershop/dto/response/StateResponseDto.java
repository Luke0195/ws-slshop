package br.com.barbershop.dto.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StateResponseDto implements Serializable{
  private Long id;
  private String name;
  private String uf;

}
