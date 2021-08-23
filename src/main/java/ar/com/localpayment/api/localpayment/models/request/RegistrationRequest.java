package ar.com.localpayment.api.localpayment.models.request;
import java.util.Date;

public class RegistrationRequest {

    public String fullName; // Nombre persona
    public int country; // pais del usuario
    public String identification; // nro documento
    public Date birthDate; // fechaNacimiento
    public String email; // email
    public String password; // contraseña elegida por el usuario.

}
