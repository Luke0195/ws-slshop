package br.com.barbershop.controllers;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.http.MediaType;


import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.barbershop.bunisses.impl.StateServiceImpl;
import br.com.barbershop.dto.request.StateRequestDto;
import br.com.barbershop.factories.StateFactory;

@SpringBootTest
@AutoConfigureMockMvc
public class StateControllerTest {
  
  @Autowired
  private MockMvc mockMvc;
  
  @MockBean
  private StateServiceImpl stateServiceImpl;
  private StateRequestDto stateRequestDto = StateFactory.makeStateRequestDto();
  @Autowired
  private ObjectMapper objectMapper;


  @BeforeEach
  void setup(){
    Mockito.when(stateServiceImpl.createState(stateRequestDto)).thenReturn(StateFactory.makeStateResponseDto(StateFactory.makeState(stateRequestDto)));
  }

  @DisplayName("POST - Should return a State when valid data is provided")
  @Test
  void createShouldReturnAStateWhenValidDataIsProvided() throws Exception{
    String jsonBody = objectMapper.writeValueAsString(this.stateRequestDto);
    ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/states").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON).content(jsonBody));
    resultActions.andExpect(MockMvcResultMatchers.status().isCreated());
  }

}
