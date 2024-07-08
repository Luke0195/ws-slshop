package br.com.barbershop.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubLocalityRequestDto implements Serializable {
    @NotEmpty(message = "The field name must be required")
    private String name;
}
