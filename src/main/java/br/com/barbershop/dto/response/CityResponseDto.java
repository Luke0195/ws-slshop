package br.com.barbershop.dto.response;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.barbershop.domain.State;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CityResponseDto implements Serializable{ 
  
  private Long id;
  private String name;
  private State state;
  @JsonProperty("created_at")
  private Instant createdAt;
  @JsonProperty("updated_at")
  private Instant updatedAt;

}
