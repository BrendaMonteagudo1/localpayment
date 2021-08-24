package ar.com.localpayment.api.localpayment.models.request;
import java.util.Date;

public class RegistrationRequest {

    public String name; // Nombre persona
    public String lastname;
    public String identification; // nro documento
    public String address;
    public Date birthDate; // fechaNacimiento
    public String email; // email
    public String password; // contraseña elegida por el usuario.

}
