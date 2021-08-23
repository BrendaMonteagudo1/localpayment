package ar.com.localpayment.api.localpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.localpayment.api.localpayment.entities.Persona;
import ar.com.localpayment.api.localpayment.models.response.GenericResponse;
import ar.com.localpayment.api.localpayment.services.PersonaService;

@RestController
public class PersonaController {

    @Autowired
    private PersonaService service;

    @PostMapping("api/pasajes")
    public ResponseEntity<GenericResponse> crearPersona(Persona persona) {

        GenericResponse respuesta = new GenericResponse();

        service.crearPersona(persona);

        respuesta.message = "La persona ha sido generada correctamente.";
        respuesta.isOk = true;
        respuesta.id = persona.getPersonaId();

        return ResponseEntity.ok(respuesta);
    }

}
