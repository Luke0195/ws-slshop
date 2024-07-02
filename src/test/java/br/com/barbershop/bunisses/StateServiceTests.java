package br.com.barbershop.bunisses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.barbershop.bunisses.impl.StateServiceImpl;
import br.com.barbershop.domain.State;
import br.com.barbershop.dto.request.StateRequestDto;
import br.com.barbershop.dto.response.StateResponseDto;
import br.com.barbershop.factories.StateFactory;
import br.com.barbershop.infra.StateRepository;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("dev")
public class StateServiceTests {

  @Mock
  private StateRepository stateRepository;
  @InjectMocks
  private StateServiceImpl stateServiceImpl;
  private StateRequestDto stateRequestDto = StateFactory.makeStateRequestDto();
  private State state = StateFactory.makeState(this.stateRequestDto);

  @BeforeEach
  void setup(){
    this.stateRepository.deleteAll();
    Mockito.when(stateRepository.save(Mockito.any())).thenReturn(state);
  }

  @Test
  @DisplayName("Create should return and StateResponseDto when valid data is provided")
  void createShouldReturnAStateResponseDtoWhenValidDataIsProvided(){
    StateResponseDto stateResponseDto = this.stateServiceImpl.createState(stateRequestDto);
    Assertions.assertNotNull(stateResponseDto);
    stateRepository.save(this.state);

  }

}
