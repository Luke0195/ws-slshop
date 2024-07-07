package br.com.barbershop.infra;

import br.com.barbershop.domain.City;
import br.com.barbershop.dto.request.CityRequestDto;
import br.com.barbershop.factories.CityFactory;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("dev")
@DataJpaTest
public class CityRepositoryTests {
   @Autowired
   private  CityRepository cityRepository;

    @BeforeEach
    void setupSuiteTests(){
        cityRepository.deleteAll();
    }

    @Test
    @DisplayName("Should return a city when valid data is provided")
    void shouldReturnACityWhenValidDataIsProvided(){
      CityRequestDto fakeCityRequestDto = CityFactory.makeCityRequestDto();
      City fakeCity = CityFactory.makeCity(fakeCityRequestDto);
      City city = cityRepository.save(fakeCity);
      city = cityRepository.save(city);
        Assertions.assertNotNull(city.getId());
        Assertions.assertNotNull(city.getName());
        Assertions.assertNotNull(city.getState());
    }

}
