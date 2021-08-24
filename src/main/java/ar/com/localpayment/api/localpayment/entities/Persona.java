package ar.com.localpayment.api.localpayment.entities;

import java.util.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.*;

import ar.com.localpayment.api.localpayment.entities.Tarjeta.MarcaTarjetaEnum;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Column(name = "persona_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer personaId;

    private String nombre;

    private String apellido;

    @NaturalId
    private String dni;

    private String direccion;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @OneToMany(mappedBy = "personaId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Tarjeta> tarjetas = new ArrayList<>();

    @OneToOne(mappedBy = "personaId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Usuario usuarioId;

    private Integer tarjetaId;

    public MarcaTarjetaEnum getTarjetaId() {
        return MarcaTarjetaEnum.parse(this.tarjetaId);
    }

    public void setTarjetaId(MarcaTarjetaEnum tarjetaId) {
        this.tarjetaId = tarjetaId.getValue();
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public void setTarjeta(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public void agregarTarjeta(Tarjeta tarjeta) {
        this.tarjetas.add(tarjeta);
    }

    public Integer getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public Usuario getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuario usuarioId) {
        this.usuarioId = usuarioId;
        //usuarioId.setPersonaId(this);
    
    }

    public void setTarjetaId(Integer tarjetaId) {
        this.tarjetaId = tarjetaId;
    }

    
}
