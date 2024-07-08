package br.com.barbershop.bunisses.mappers;

import br.com.barbershop.domain.SubLocality;
import br.com.barbershop.dto.request.SubLocalityRequestDto;
import br.com.barbershop.dto.response.SubLocalityResponseDto;

public class SubLocalityMapper {

    private SubLocalityMapper(){}

    public static SubLocality mapSubLocalityRequestDtoToEntity(SubLocalityRequestDto subLocalityRequestDto){
        return SubLocality.builder().name(subLocalityRequestDto.getName()).build();
    }

    public static  SubLocalityResponseDto mapSubLocalityEntityToSubLocalityResponseDto(SubLocality entity){
        return SubLocalityResponseDto.builder().id(entity.getId()).name(entity.getName()).createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt()).build();
    }
}
