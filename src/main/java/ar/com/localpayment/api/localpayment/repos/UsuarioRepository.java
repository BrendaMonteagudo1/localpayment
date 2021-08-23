package ar.com.localpayment.api.localpayment.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.localpayment.api.localpayment.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository <Usuario, Integer>{
    
    public Usuario findByUsername(String userName);

    public Usuario findByEmail(String email);

}
