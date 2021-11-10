package br.com.letscode.spring.projetofinal.repository;

import br.com.letscode.spring.projetofinal.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query(value = "SELECT * FROM Usuarios u WHERE u.email = ?1 and u.senha = ?2", nativeQuery = true)
    Usuario findByEmailAndSenha(String email, String senha);
}
