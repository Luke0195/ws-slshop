package br.com.barbershop.controllers;

import br.com.barbershop.bunisses.impl.SubLocalityServiceImp;
import br.com.barbershop.dto.request.SubLocalityRequestDto;
import br.com.barbershop.dto.response.SubLocalityResponseDto;
import br.com.barbershop.utils.http.HttpUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping(value = "/sublocalities")
@AllArgsConstructor
public class SubLocalityController {

    private final SubLocalityServiceImp serviceImp;

    @PostMapping
    public ResponseEntity<SubLocalityResponseDto> createSubLocality(@Valid @RequestBody SubLocalityRequestDto requestDto){
        SubLocalityResponseDto responseData = serviceImp.createSubLocality(requestDto);
        URI uri = HttpUtil.getUriFromRequest(responseData.getId());
        return HttpUtil.getCreatedResponse(responseData, uri);
    }
}
