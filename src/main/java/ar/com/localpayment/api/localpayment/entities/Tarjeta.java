package ar.com.localpayment.api.localpayment.entities;

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
    private Integer personaId;

    private String marca;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;

    private Integer limite;

    private Integer tasa;
    
    

    public Integer getLimite() {
        return limite;
    }

    public void setLimite(Integer limite) {
        this.limite = limite;
    }

    public Integer getTasa() {
        return tasa;
    }

    public void setTasa(Integer tasa) {
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

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
        this.personaId.agregarTarjeta(this);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
