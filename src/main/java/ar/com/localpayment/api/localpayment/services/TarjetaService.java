package ar.com.localpayment.api.localpayment.services;

import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.localpayment.api.localpayment.entities.Tarjeta;
import ar.com.localpayment.api.localpayment.repos.TarjetaRepository;


@Service
public class TarjetaService {
    @Autowired
    private TarjetaRepository repo;

    public void crearTarjeta(Tarjeta tarjeta) {
        repo.save(tarjeta);
    }

    public Tarjeta buscarPorId(Integer id) { // a) Invocar un método que devuelva toda la información de una tarjeta
        return repo.findByTarjetaId(id);
    }

    // Una tarjeta es válida para operar si su fecha de vencimiento es mayor al
    // presente día

    public boolean validarTarjetaPorVencimiento(Tarjeta tarjeta) {

        Calendar c = Calendar.getInstance();
        // c.setTime(tarjeta.getFecha());
        c.add(Calendar.DATE, 1);

        // if (tarjeta.getFechaVencimiento().after(Calendar.getInstance(){
        return true;
    }

    public Tarjeta buscarTarjeta(Integer tarjetaId){
     Optional<Tarjeta> resultado = repo.findById(tarjetaId);

     if(resultado.isPresent())
        return resultado.get();
    
     return null;
    }


    public List<Tarjeta> traerTarjetas() {
        return repo.findAll();
    }
    
}
