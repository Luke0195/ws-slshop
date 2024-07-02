package br.com.barbershop.controllers.exceptions;

import java.io.Serializable;
import java.time.Instant;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StandardResponseDto implements Serializable {
  
  private Instant timestamp;
  private Integer status;
  private String error;
  private String path;
  @JsonProperty("exception_message")
  private String exceptionMessage;
  private List<Object> errors;
}
