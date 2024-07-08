package br.com.barbershop.bunisses.usecases;

import br.com.barbershop.dto.request.SubLocalityRequestDto;
import br.com.barbershop.dto.response.SubLocalityResponseDto;

public interface SubLocalityService {
    SubLocalityResponseDto createSubLocality(SubLocalityRequestDto requestDto);
}
