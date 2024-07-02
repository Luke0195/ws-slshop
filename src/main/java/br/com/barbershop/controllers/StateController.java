package br.com.barbershop.controllers;



import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.barbershop.bunisses.impl.StateServiceImpl;
import br.com.barbershop.dto.request.StateRequestDto;
import br.com.barbershop.dto.response.StateResponseDto;
import br.com.barbershop.utils.http.HttpUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/states")
@AllArgsConstructor
public class StateController {
  
  private final StateServiceImpl stateServiceImpl;

  @PostMapping
  public ResponseEntity<StateResponseDto> createState(@Valid @RequestBody StateRequestDto stateRequestDto){
    StateResponseDto stateResponseDto = stateServiceImpl.createState(stateRequestDto);
    return HttpUtil.getCreatedResponse(stateResponseDto, stateResponseDto.getId());
  }
}
