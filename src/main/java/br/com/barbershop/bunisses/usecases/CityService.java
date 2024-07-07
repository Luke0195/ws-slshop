package br.com.barbershop.bunisses.usecases;

import br.com.barbershop.dto.request.CityRequestDto;
import br.com.barbershop.dto.response.CityResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CityService {
  CityResponseDto createCity(CityRequestDto requestDto);
  Page<CityResponseDto> findAll(Pageable pageable);
}
