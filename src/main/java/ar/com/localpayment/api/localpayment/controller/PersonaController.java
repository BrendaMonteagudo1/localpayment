package ar.com.localpayment.api.localpayment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    

    @PostMapping("api/pasajes")
    public ResponseEntity<GenericResponse> crearPersona(Persona persona) {
        
        GenericResponse respuesta = new GenericResponse();

        Persona persona = service.crearPersona(infoPasajes.reservaId);

        respuesta.message = "El pasaje ha sido generada correctamente.";
        respuesta.isOk = true;
        respuesta.id = pasaje.getPasajeId();



        
        return ResponseEntity.ok(respuesta);
    }
    

}
