package ar.com.localpayment.api.localpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    
    @Autowired
     private PersonaService service;

     @PostMapping("api/pasajes")
     public ResponseEntity<GenericResponse> crearPersona(Persona persona) {
        
        GenericResponse respuesta = new GenericResponse();

        Persona persona = service.crearPersona(persona);

        respuesta.message = "La persona ha sido generada correctamente.";
        respuesta.isOk = true;
        respuesta.id = persona.getPersonaId();


        return ResponseEntity.ok(respuesta);
    }
    

}
