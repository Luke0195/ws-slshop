package br.com.barbershop.dto.request;

import java.io.Serializable;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityRequestDto implements Serializable{
  private Long id;
  private String name;
  @JsonProperty("state_id")
  private Long stateId;
}
