package br.com.barbershop.infra;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import br.com.barbershop.domain.State;
import br.com.barbershop.dto.request.StateRequestDto;
import br.com.barbershop.factories.StateFactory;

@DataJpaTest
@ActiveProfiles("dev")
public class StateRepositoryTests {

  @Autowired
  private  StateRepository stateRepository;

  @Test
  @DisplayName("Save should return an entity when valid data is provided")
  void saveShouldReturnAnEntityWhenValidDataIsProvided(){
    StateRequestDto requestDto = StateFactory.makeStateRequestDto();
    State entity = StateFactory.makeState(requestDto);
    entity = stateRepository.save(entity);
    Assertions.assertNotNull(entity);
    Assertions.assertNotNull(entity.getId());
    Assertions.assertNotNull(entity.getName());
    Assertions.assertNotNull(entity.getUf());
    
  }

}
