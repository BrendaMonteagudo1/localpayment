package ar.com.localpayment.api.localpayment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import ar.com.localpayment.api.localpayment.entities.*;
import ar.com.localpayment.api.localpayment.models.response.GenericResponse;
import ar.com.localpayment.api.localpayment.services.*;

@RestController
public class TarjetaController {

    @Autowired
    private TarjetaService service;
    
    @PostMapping("api/tarjetas")
    public ResponseEntity<GenericResponse> crearTarjeta(Tarjeta tarjeta) {

        GenericResponse respuesta = new GenericResponse();

        service.crearTarjeta(tarjeta);

        respuesta.message = "La tarjeta ha sido generada correctamente.";
        respuesta.isOk = true;
        respuesta.id = tarjeta.getTarjetaId();

        return ResponseEntity.ok(respuesta);
    }



    
}
