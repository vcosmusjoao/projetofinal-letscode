package br.com.letscode.spring.projetofinal.repository;

import br.com.letscode.spring.projetofinal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u WHERE u.email = ?1")
    public Usuario findByEmail(String email);


}
