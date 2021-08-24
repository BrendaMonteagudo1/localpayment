package ar.com.localpayment.api.localpayment.services;
import ar.com.localpayment.api.localpayment.services.UsuarioService;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import ar.com.localpayment.api.localpayment.entities.Usuario;
import ar.com.localpayment.api.localpayment.repos.UsuarioRepository;
import ar.com.localpayment.api.localpayment.security.Crypto;

public class UsuarioService {

  @Autowired
  UsuarioRepository usuarioRepository;

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

  public Usuario crearUsuario(String nombre, Date fechaNacimDate, String dni, String email, String password) {
    Usuario usuario = new Usuario();
    return usuarioRepository.save(usuario);
  }

   // Usamos el tipo de datos SET solo para usar otro diferente a List private
   Set<? extends GrantedAuthority> getAuthorities(Usuario usuario) {

    Set<SimpleGrantedAuthority> authorities = new HashSet<>();

     return authorities;
  }

}
