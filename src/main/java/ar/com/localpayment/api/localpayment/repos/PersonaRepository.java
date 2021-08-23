package ar.com.localpayment.api.localpayment.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.localpayment.api.localpayment.entities.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Integer>{
    
}
