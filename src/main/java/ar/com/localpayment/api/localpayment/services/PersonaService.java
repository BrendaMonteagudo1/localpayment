package ar.com.localpayment.api.localpayment.services;

import java.util.Optional;

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

    public Persona buscarPersona(Integer Id) {
        Optional<Persona> resultado = repo.findById(Id);

        if(resultado.isPresent())
            return resultado.get();
        
        
        return null;
        
    }

    
}
