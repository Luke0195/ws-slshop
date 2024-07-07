package br.com.barbershop.bunisses;

import br.com.barbershop.bunisses.exceptions.InvalidParamException;
import br.com.barbershop.bunisses.exceptions.ResourceAlreadyExistsException;
import br.com.barbershop.bunisses.impl.CityServiceImpl;
import br.com.barbershop.domain.City;
import br.com.barbershop.domain.State;
import br.com.barbershop.dto.request.CityRequestDto;
import br.com.barbershop.dto.response.CityResponseDto;
import br.com.barbershop.factories.CityFactory;
import br.com.barbershop.factories.StateFactory;
import br.com.barbershop.infra.CityRepository;
import br.com.barbershop.infra.StateRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.Optional;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader= AnnotationConfigContextLoader.class, classes = CityServiceTests.class)
@ActiveProfiles("dev")
public class CityServiceTests {
    @InjectMocks
    private CityServiceImpl service;

    @Mock
    private CityRepository cityRepository;

    @Mock
    private StateRepository stateRepository;

    private CityRequestDto cityRequestDto;
    private CityRequestDto existsCityRequestDto;
    private CityRequestDto validCityRequest;
    private City validCity;
    private State validState;


    @BeforeEach
    void setupSuiteTests(){

     this.cityRequestDto = CityFactory.makeCityRequestDto();
     this.existsCityRequestDto = CityFactory.makeCityRequestDto();
     this.existsCityRequestDto.setName("any_existing_city");
     this.validCityRequest = new CityRequestDto(2L, "valid_city_name",1L);
     this.validCity = CityFactory.makeCity(validCityRequest);
     this.validState = StateFactory.makeState(StateFactory.makeStateRequestDto());
     Mockito.doThrow(ResourceAlreadyExistsException.class).when(cityRepository).findCityByName(existsCityRequestDto.getName());
     Mockito.doThrow(InvalidParamException.class).when(stateRepository).findById(this.cityRequestDto.getStateId());
     Mockito.when(cityRepository.findCityByName(validCityRequest.getName())).thenReturn(Optional.empty());


    }

    @DisplayName("Should throws ResourceAlreadyExistsException if city name already exists")
    @Test
    void shouldThrowsResourceAlreadyExistsExceptionIfCityNameAlreadyExists(){
     Assertions.assertThrows(ResourceAlreadyExistsException.class, () -> {
        service.createCity(existsCityRequestDto);
     });
     Mockito.verify(cityRepository).findCityByName(existsCityRequestDto.getName());

    }

    @DisplayName("Should throws InvalidParamException if invalid stateId is provided")
    @Test
    void shouldThrowsInvalidParamExceptionIfInvalidStateIdIsProvided(){
      Assertions.assertThrows(InvalidParamException.class, () -> {
         service.createCity(this.cityRequestDto);
      });
      Mockito.verify(stateRepository).findById(this.cityRequestDto.getStateId());
    }





}

