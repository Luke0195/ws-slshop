package br.com.barbershop.infra;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.barbershop.domain.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{
  @Query(value = "SELECT obj FROM State obj where obj.name =:name")
  Optional<State> findStateByName(String name);
  @Query(value = "SELECT obj FROM State obj where obj.uf =:uf")
  Optional<State> findStateByUf(String uf);

}
