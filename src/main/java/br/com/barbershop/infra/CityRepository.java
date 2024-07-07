package br.com.barbershop.infra;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import br.com.barbershop.domain.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long>{
  @Query(value = "SELECT obj FROM City obj where obj.name =:name")
  Optional<City> findCityByName(String name);
}
