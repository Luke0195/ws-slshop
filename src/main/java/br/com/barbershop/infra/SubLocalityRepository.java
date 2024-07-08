package br.com.barbershop.infra;

import br.com.barbershop.domain.SubLocality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubLocalityRepository extends JpaRepository<SubLocality, Long> {

    @Query(name = "SELECT obj FROM SubLocality obj where obj.name =:name")
    Optional<SubLocality> findLocalityByName(String name);

}
