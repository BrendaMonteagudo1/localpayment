package ar.com.localpayment.api.localpayment.services;
import java.util.*;
import java.math.BigDecimal;

import ar.com.localpayment.api.localpayment.entities.Tarjeta;

public class TarjetaSCOCalculoStrategy implements ITarjetaCalculoStrategy  {


    private Tarjeta tarjeta;


    @Override
    public void init(Tarjeta tarjeta) {
        this.tarjeta = tarjeta; 
    }


    @Override
    public BigDecimal calcularTasa() {
        // dia del mes *0.5
        Date hoy = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(hoy);
        int diaDelMes = c.get(Calendar.DAY_OF_MONTH);

        return new BigDecimal(diaDelMes * 0.5);

    }
    
    
}
