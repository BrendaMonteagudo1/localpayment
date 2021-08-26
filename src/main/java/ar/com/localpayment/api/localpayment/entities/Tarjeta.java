package ar.com.localpayment.api.localpayment.entities;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.annotations.*;

@Entity
@Table (name = "tarjeta")
public class Tarjeta {
    @Id
    @Column(name = "tarjeta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tarjetaId;

    @Column(name = "numero_tarjeta")
    @NaturalId
    private String numTarjeta;

    @ManyToOne //join columns van donde esta FK
    @JoinColumn(name = "persona_id", referencedColumnName = "persona_id")
    private Persona personaId;

    @Column(name = "marca_tarjeta_id")
    private String marcaTarjetaId;

    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    private Integer limite;

    private BigDecimal tasa;

    private BigDecimal consumo;
    
    

    public BigDecimal getConsumo() {
        return consumo;
    }

    public void setConsumo(BigDecimal consumo) {
        this.consumo = consumo;
    }

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public BigDecimal getTasa() {
        return tasa;
    }

    public void setTasa(BigDecimal tasa) {
        this.tasa = tasa;
    }

    public Integer getTarjetaId() {
        return tarjetaId;
    }

    public void setTarjetaId(Integer tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    public String getNumTarjeta() {
        return numTarjeta;
    }

    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }

    public Persona getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Persona personaId) {
        this.personaId = personaId;
        this.personaId.agregarTarjeta(this);
    }

    public String getMarca() {
        return marcaTarjetaId;
    }

    public void setMarca(String marcaTarjetaId) {
        this.marcaTarjetaId = marcaTarjetaId;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }


    public enum MarcaTarjetaEnum {
        SQUA(1), SCO(2), PERE(3);

        private final Integer value;

        private MarcaTarjetaEnum(Integer value) {
            this.value = value;
        }
        public Integer getValue() {
            return value;
        }

        public static MarcaTarjetaEnum parse(Integer id) {
            MarcaTarjetaEnum status = null; // Default
            for (MarcaTarjetaEnum item : MarcaTarjetaEnum.values()) {
                if (item.getValue().equals(id)) {
                    status = item;
                    break;
                }
            }
            return status;
        }
    }



    
}
