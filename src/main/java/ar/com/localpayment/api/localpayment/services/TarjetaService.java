package ar.com.localpayment.api.localpayment.services;

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

public Tarjeta buscarPorId(Integer id) {
    return repo.findByTarjetaId(id);
}
    
}
