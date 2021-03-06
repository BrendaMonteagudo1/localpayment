package ar.com.localpayment.api.localpayment.services;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import org.hibernate.type.CalendarTimeType;

import ar.com.localpayment.api.localpayment.entities.Tarjeta;

public class TarjetaPERECalculoStrategy implements ITarjetaCalculoStrategy {

    private Tarjeta tarjeta;

    public void init(Tarjeta tarjeta) {

        this.tarjeta = tarjeta;
    }

    public BigDecimal calcularTasa() {
        // Tasa PERE = mes*0.1
        Date hoy = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(hoy);
        int mes = c.get(Calendar.MONTH);

        return new BigDecimal(mes * 0.1);

    }

}
