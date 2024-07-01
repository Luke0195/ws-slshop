package br.com.barbershop.bunisses.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.barbershop.bunisses.exceptions.ResourceAlreadyExistsException;
import br.com.barbershop.bunisses.usecases.StateService;
import br.com.barbershop.domain.State;
import br.com.barbershop.dto.request.StateRequestDto;
import br.com.barbershop.dto.response.StateResponseDto;
import br.com.barbershop.infra.StateRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StateServiceImpl implements StateService {

  private final StateRepository stateRepository;
 
  
  @Override
  @Transactional
  public StateResponseDto createState(StateRequestDto stateRequestDto) {
    Optional<State> findStateByName = stateRepository.findStateByName(stateRequestDto.getName());
    if(findStateByName.isPresent()) throw new ResourceAlreadyExistsException(getExceptionMessage("name"));
    Optional<State> findStateByUf = stateRepository.findStateByUf(stateRequestDto.getUf());
    if(findStateByUf.isPresent()) throw new ResourceAlreadyExistsException(getExceptionMessage("uf"));
    State createState = new State();
    createState.setName(stateRequestDto.getName());
    createState.setUf(stateRequestDto.getUf());
    createState = stateRepository.save(createState);
    return StateResponseDto.builder().id(createState.getId()).name(createState.getName()).uf(createState.getUf()).build();

 
  }

  private static String getExceptionMessage(String paramName){
    return String.format("This state %s already exists!", paramName);
  }
  
}
