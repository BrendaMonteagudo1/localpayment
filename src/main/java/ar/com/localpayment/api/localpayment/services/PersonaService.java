package ar.com.localpayment.api.localpayment.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.localpayment.api.localpayment.entities.Persona;
import ar.com.localpayment.api.localpayment.repos.PersonaRepository;

@Service
public class PersonaService {
    @Autowired
    private PersonaRepository repo; 
    
    public void crearPersona(Persona persona) {
        repo.save(persona);
    }

    // solo genero crear porque el findById seria para usuario (?)

}
