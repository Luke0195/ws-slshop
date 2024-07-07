package br.com.barbershop.bunisses.mappers;

import br.com.barbershop.domain.State;
import br.com.barbershop.dto.request.StateRequestDto;
import br.com.barbershop.dto.response.StateResponseDto;

public class StateMapper {
  
  private StateMapper(){};

  public static State parseStateRequestDtoToEntity(StateRequestDto requestDto){
    return State.builder().name(requestDto.getName()).uf(requestDto.getUf()).build();
  }

  public static StateResponseDto parseEntityToStateResponseDto(State entity){
    return StateResponseDto
    .builder()
    .id(entity.getId())
    .name(entity.getName())
    .uf(entity.getUf())
    .createdAt(entity.getCreatedAt())
    .updatedAt(entity.getUpdatedAt())
    .build();
  }
}
