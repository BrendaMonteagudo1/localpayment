package ar.com.localpayment.api.localpayment.entities;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;


import ar.com.localpayment.api.localpayment.services.TarjetaService;

public class Operacion {
    @Autowired
    TarjetaService service;

    private BigDecimal consumo;


    public BigDecimal getConsumo() {
        return consumo;
    }

    public void setConsumo(BigDecimal consumo) {
        this.consumo = consumo;
    }

}
