package br.com.barbershop.factories;

import br.com.barbershop.domain.City;
import br.com.barbershop.domain.State;
import br.com.barbershop.dto.request.CityRequestDto;
;
import br.com.barbershop.dto.response.CityResponseDto;

public class CityFactory {

    private CityFactory(){};

    public static CityRequestDto makeCityRequestDto(){
       return CityRequestDto.builder().id(1L).name("any_name").stateId(1L).build();
    };

    public static City makeCity(CityRequestDto cityRequestDto){
        State state = StateFactory.makeState(StateFactory.makeStateRequestDto());
        return City.builder().id(1L).name(cityRequestDto.getName()).state(state).build();
    }

    public static CityResponseDto makeCityResponseDto(City city){
        return CityResponseDto.builder().id(city.getId()).name(city.getName()).state(city.getState()).build();
    }
}
