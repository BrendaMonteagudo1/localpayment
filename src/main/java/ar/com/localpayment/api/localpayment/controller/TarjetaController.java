package ar.com.localpayment.api.localpayment.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import ar.com.localpayment.api.localpayment.entities.*;
import ar.com.localpayment.api.localpayment.entities.Tarjeta.MarcaTarjetaEnum;
import ar.com.localpayment.api.localpayment.models.response.GenericResponse;
import ar.com.localpayment.api.localpayment.services.*;

@RestController
public class TarjetaController {

    @Autowired
    private TarjetaService service;
    
    @PostMapping("api/tarjetas")
    public ResponseEntity<GenericResponse> crearTarjeta(Tarjeta tarjeta){
        GenericResponse respuesta = new GenericResponse();
        

        service.crearTarjeta(tarjeta);

        respuesta.message = "La tarjeta ha sido generada correctamente.";
        respuesta.isOk = true;
        respuesta.id = tarjeta.getTarjetaId();

        return ResponseEntity.ok(respuesta);
    }



   /* @PostMapping("/api/tarjetas")
    public ResponseEntity<GenericResponse> postCrearVuelo(@RequestBody Tarjeta tarjeta) {
        GenericResponse respuesta = new GenericResponse();

        MarcaTarjetaEnum resultadoValidacion = service.validarMarca(tarjeta);
        if (resultadoValidacion == MarcaTarjetaEnum.valueOf(null)) {
            service.crearTarjeta(tarjeta);

            respuesta.isOk = true;
            respuesta.id = tarjeta.getTarjetaId();
            respuesta.message = "tarjeta ingresada";

            return ResponseEntity.ok(respuesta);
        } else {

            respuesta.isOk = false;
            respuesta.message = "Error(" + resultadoValidacion.toString() + ")";

            return ResponseEntity.badRequest().body(respuesta);
        }

    }*/

    @GetMapping("api/tarjetas/{id}")
    public ResponseEntity<Tarjeta> getTarjetaPorId(@PathVariable Integer id){
        Tarjeta tarjeta = service.buscarTarjeta(id);

        return ResponseEntity.ok(tarjeta);
    }

    @GetMapping("/tarjetas")
    public ResponseEntity<List<Tarjeta>> traerTarjetas() {
        List<Tarjeta> lista = service.traerTarjetas();

        return ResponseEntity.ok(lista);
    }

    
    @GetMapping("api/tarjetas/enum")
    public ResponseEntity<Tarjeta> getTarjetPorId(@PathVariable Integer id){
        Tarjeta tarjeta = service.buscarTarjeta(id);

        return ResponseEntity.ok(tarjeta);
    }


}
