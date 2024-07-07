package br.com.barbershop.bunisses.impl;


import java.util.Optional;

import br.com.barbershop.bunisses.exceptions.InvalidParamException;
import br.com.barbershop.bunisses.mappers.CityMapper;

import br.com.barbershop.domain.State;
import br.com.barbershop.infra.StateRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.barbershop.bunisses.exceptions.ResourceAlreadyExistsException;
import br.com.barbershop.bunisses.usecases.CityService;
import br.com.barbershop.domain.City;
import br.com.barbershop.dto.request.CityRequestDto;
import br.com.barbershop.dto.response.CityResponseDto;
import br.com.barbershop.infra.CityRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {
  
  private final CityRepository cityRepository;
  private final StateRepository stateRepository;

  @Override
  @Transactional(readOnly = true)  
  public CityResponseDto createCity(CityRequestDto requestDto) {
   Optional<City> findCityByName = cityRepository.findCityByName(requestDto.getName());
   if(findCityByName.isPresent()) throw new ResourceAlreadyExistsException("This city name is already taken!");
   State findStateById = stateRepository.findById(requestDto.getStateId()).orElseThrow(() -> new InvalidParamException("state_id not found!"));
   City createdCity = CityMapper.parseCityRequestDtoToCityEntity(requestDto, findStateById);
   createdCity = cityRepository.save(createdCity);
   return CityMapper.parseCityEntityToCityResponseDto(createdCity);
  }

    @Override
    @Transactional(readOnly = true)
    public Page<CityResponseDto> findAll(Pageable pageable) {
        Page<City> cities = cityRepository.findAll(pageable);
        return cities.map(CityMapper::parseCityEntityToCityResponseDto);
    }
}
