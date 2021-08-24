package ar.com.localpayment.api.localpayment.services;

import java.math.BigDecimal;

import ar.com.localpayment.api.localpayment.entities.Tarjeta;

public interface ITarjetaCalculoStrategy {
    
    public BigDecimal calcularTasa();
    public void init (Tarjeta tarjeta);
}
