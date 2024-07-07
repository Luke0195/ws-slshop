package br.com.barbershop.bunisses.mappers;

import br.com.barbershop.domain.City;
import br.com.barbershop.domain.State;
import br.com.barbershop.dto.request.CityRequestDto;
import br.com.barbershop.dto.response.CityResponseDto;


public class CityMapper {

    private CityMapper(){}

    public static City parseCityRequestDtoToCityEntity(CityRequestDto cityRequestDto, State state){
        return City.builder()
                .name(cityRequestDto.getName())
                .state(state)
                .build();
    }

    public static CityResponseDto parseCityEntityToCityResponseDto(City city){
        return CityResponseDto.builder()
                .id(city.getId())
                .name(city.getName())
                .state(city.getState())
                .createdAt(city.getCreatedAt())
                .updatedAt(city.getUpdatedAt())
                .build();
    }


}
