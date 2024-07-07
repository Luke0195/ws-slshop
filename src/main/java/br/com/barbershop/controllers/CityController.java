package br.com.barbershop.controllers;

import br.com.barbershop.bunisses.impl.CityServiceImpl;
import br.com.barbershop.dto.request.CityRequestDto;
import br.com.barbershop.dto.response.CityResponseDto;
import br.com.barbershop.utils.http.HttpUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/cities")
@AllArgsConstructor
public class CityController {

    private final CityServiceImpl cityServiceImpl;

    @PostMapping
    public ResponseEntity<CityResponseDto> createCity(@Valid @RequestBody CityRequestDto cityRequestDto){
      CityResponseDto cityResponseDto = cityServiceImpl.createCity(cityRequestDto);
      URI uri = HttpUtil.getUriFromRequest(cityResponseDto.getId());
      return HttpUtil.getCreatedResponse(cityResponseDto, uri);
    }

    @GetMapping
    public ResponseEntity<Page<CityResponseDto>> findAllPaged(
            @RequestParam(value="page", defaultValue = "0") Integer page,
            @RequestParam(value="linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value="orderBy", defaultValue = "name") String orderBy,
            @RequestParam(value="direction", defaultValue ="ASC") String direction
    ){
        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
        Page<CityResponseDto> responseData = cityServiceImpl.findAll(pageRequest);
        return ResponseEntity.status(HttpStatus.OK).body(responseData);
    }
}
