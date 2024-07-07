package br.com.barbershop.controllers;

import br.com.barbershop.bunisses.impl.CityServiceImpl;
import br.com.barbershop.dto.request.CityRequestDto;
import br.com.barbershop.dto.response.CityResponseDto;
import br.com.barbershop.factories.CityFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private CityServiceImpl service;
    private CityRequestDto cityRequestDto = CityFactory.makeCityRequestDto();
    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        Mockito.when(service.createCity(this.cityRequestDto)).thenReturn(CityFactory.makeCityResponseDto(CityFactory.makeCity(cityRequestDto)));
    }

    @DisplayName("POST - Should return 201 and cityResponseDto when valid data is provided")
    @Test
    void createShouldReturnACityWhenValidDataIsProvided() throws Exception{
        String jsonBody= objectMapper.writeValueAsString(this.cityRequestDto);
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/cities")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON).content(jsonBody));
        resultActions.andExpect(MockMvcResultMatchers.status().isCreated());
    }
}
