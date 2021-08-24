package ar.com.localpayment.api.localpayment.services;

import java.util.*;
import java.math.BigDecimal;

import ar.com.localpayment.api.localpayment.entities.Tarjeta;

public class TarjetaSQUACalculoStrategy implements ITarjetaCalculoStrategy {

    private Tarjeta tarjeta;

    @Override
    public BigDecimal calcularTasa() {
        // year dividido mes 
        Date hoy = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(hoy);
        int mes = c.get(Calendar.MONTH);
        int year = c.get(Calendar.YEAR);

        return new BigDecimal(year / mes);

    }

    @Override
    public void init(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;

    }

}
