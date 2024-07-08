package br.com.barbershop.bunisses.impl;

import br.com.barbershop.bunisses.exceptions.ResourceAlreadyExistsException;
import br.com.barbershop.bunisses.mappers.SubLocalityMapper;
import br.com.barbershop.bunisses.usecases.SubLocalityService;
import br.com.barbershop.domain.SubLocality;
import br.com.barbershop.dto.request.SubLocalityRequestDto;
import br.com.barbershop.dto.response.SubLocalityResponseDto;
import br.com.barbershop.infra.SubLocalityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SubLocalityServiceImp implements SubLocalityService {

    private final SubLocalityRepository subLocalityRepository;

    @Override
    @Transactional
    public SubLocalityResponseDto createSubLocality(SubLocalityRequestDto requestDto) {
     Optional<SubLocality> subLocalityAlreadyExists = subLocalityRepository.findLocalityByName(requestDto.getName());
     if(subLocalityAlreadyExists.isPresent()) throw new ResourceAlreadyExistsException("This subLocality is already taken!");
     SubLocality createdSublocality = SubLocalityMapper.mapSubLocalityRequestDtoToEntity(requestDto);
     createdSublocality = subLocalityRepository.save(createdSublocality);
     return SubLocalityMapper.mapSubLocalityEntityToSubLocalityResponseDto(createdSublocality);
    }
}
