package ar.com.localpayment.api.localpayment.services;
import ar.com.localpayment.api.localpayment.services.UsuarioService;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import ar.com.localpayment.api.localpayment.entities.Usuario;
import ar.com.localpayment.api.localpayment.repos.UsuarioRepository;
import ar.com.localpayment.api.localpayment.security.Crypto;
import ar.com.localpayment.api.localpayment.entities.Persona;
import ar.com.localpayment.api.localpayment.repos.PersonaRepository;

@Service
public class UsuarioService {

  @Autowired
  UsuarioRepository usuarioRepository;
  
  @Autowired
  PersonaRepository personaRepository;

  public Usuario buscarPorUsername(String username) {
    return usuarioRepository.findByUsername(username);
  }

  public Usuario login(String username, String password) {

   Usuario u = buscarPorUsername(username);

    if (u == null || !u.getPassword().equals(Crypto.encrypt(password, u.getUsername()))) {

      throw new BadCredentialsException("Usuario o contraseña invalida");
    }

    return u;
  }

  public Usuario buscarPorEmail(String email) {

    return usuarioRepository.findByEmail(email);
  }

  public Usuario buscarPor(Integer id) {
    Optional<Usuario> usuarioOp = usuarioRepository.findById(id);

    if (usuarioOp.isPresent()) {
      return usuarioOp.get();
    }

    return null;
  }

  public Map<String, Object> getUserClaims(Usuario usuario) {
    Map<String, Object> claims = new HashMap<>();

    return claims;
  }

  public UserDetails getUserAsUserDetail(Usuario usuario) {
    UserDetails uDetails;

    uDetails = new User(usuario.getUsername(), usuario.getPassword(), getAuthorities(usuario));

    return uDetails;
  }

  public Usuario crearUsuario(String nombre, String apellido, String dni, String direccion, Date fechaNacimiento, String email, String password) {
    Persona persona = new Persona();
    persona.setNombre(nombre);
    persona.setApellido(apellido);
    persona.setDireccion(direccion);
    persona.setFechaNacimiento(fechaNacimiento);
    persona.setDni(dni);

    Usuario usuario = new Usuario();
    usuario.setEmail(email);
    usuario.setPassword(password);
    usuario.setUsername(usuario.getEmail());

    
    usuario.setPersonaId(persona);

    personaRepository.save(persona);

    return usuario;

  }

   // Usamos el tipo de datos SET solo para usar otro diferente a List private
   Set<? extends GrantedAuthority> getAuthorities(Usuario usuario) {

    Set<SimpleGrantedAuthority> authorities = new HashSet<>();

  
    return authorities;
  }
  

}
