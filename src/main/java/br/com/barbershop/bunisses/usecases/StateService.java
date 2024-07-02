package br.com.barbershop.bunisses.usecases;

import org.springframework.data.domain.PageRequest;

import br.com.barbershop.dto.request.StateRequestDto;
import br.com.barbershop.dto.response.StateResponseDto;

public interface StateService{

  StateResponseDto createState(StateRequestDto stateRequestDto);
 

  
}
