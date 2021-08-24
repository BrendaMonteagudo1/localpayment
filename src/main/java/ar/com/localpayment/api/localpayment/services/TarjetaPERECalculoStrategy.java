package ar.com.localpayment.api.localpayment.services;
import java.math.BigDecimal;
import ar.com.localpayment.api.localpayment.entities.Tarjeta;

public class TarjetaPERECalculoStrategy implements ITarjetaCalculoStrategy {
    
    
    private Tarjeta tarjeta;
    public void init (Tarjeta tarjeta) {
        
        this.tarjeta = tarjeta;
    }


    public BigDecimal calcularTasa(){
// Tasa PERE  = mes*0.1

    }

}
