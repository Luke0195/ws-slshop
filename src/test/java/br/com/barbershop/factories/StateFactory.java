package br.com.barbershop.factories;

import br.com.barbershop.domain.State;
import br.com.barbershop.dto.request.StateRequestDto;
import br.com.barbershop.dto.response.StateResponseDto;

public class StateFactory {

  private StateFactory(){};


  public static StateRequestDto makeStateRequestDto(){
    return StateRequestDto.builder().name("any_name").uf("any_uf").build();
  };

  public static State makeState(StateRequestDto stateRequestDto){
   return State.builder().id(1L).name(stateRequestDto.getName()).uf(stateRequestDto.getUf()).build();
  }

  public static StateResponseDto makeStateResponseDto(StateResponseDto stateResponseDto){
    return StateResponseDto.builder().id(stateResponseDto.getId()).name(stateResponseDto.getName()).uf(stateResponseDto.getUf()).build();
  }

}
