package ar.com.localpayment.api.localpayment.services;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.localpayment.api.localpayment.entities.Persona;
import ar.com.localpayment.api.localpayment.entities.Tarjeta;
import ar.com.localpayment.api.localpayment.entities.Tarjeta.MarcaTarjetaEnum;
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



    public boolean validarTarjetaPorVencimiento(Tarjeta tarjeta) {
        Date hoy = new Date();
        Calendar c = Calendar.getInstance();
         c.setTime(hoy);
         c.add(Calendar.MONTH, 1);
     if (tarjeta.getFechaVencimiento().after(hoy));
        return true;
    }


    public Tarjeta buscarTarjeta(Integer tarjetaId) {
        Optional<Tarjeta> resultado = repo.findById(tarjetaId);

        if (resultado.isPresent())
            return resultado.get();

        return null;
    }

    public List<Tarjeta> traerTarjetas() {
        return repo.findAll();
    }

    // pasar a entity/service operacion
    public BigDecimal calcularTasaPorServicio(Tarjeta tarjeta, Persona personaTarjeta) {

        // Persona tarjetaPersona = new Persona();
        ITarjetaCalculoStrategy calculo = null;
        switch (tarjeta.getMarca()) {
            case "PERE":
                calculo = new TarjetaPERECalculoStrategy();

            case "SCO":
                calculo = new TarjetaSCOCalculoStrategy();

            case "SQUA":
                calculo = new TarjetaSQUACalculoStrategy();

            default:
                break;
        }

        calculo.init(tarjeta);

        return calculo.calcularTasa();

    }

    public MarcaTarjetaEnum validarMarca(String str) {
        for (MarcaTarjetaEnum me : MarcaTarjetaEnum.values()) {
            if (me.name().equalsIgnoreCase(str))
                return me;
        }
        return null;
    }
    

    public boolean validarPrecio(Tarjeta consumo) {

        if (consumo.getConsumo() == null) {
            return false;
        }
        if (consumo.getConsumo().doubleValue() < 100)
            return true;

        return false;
    }

}
