package br.com.letscode.spring.projetofinal.repository;

import br.com.letscode.spring.projetofinal.model.Anotacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {
    @Query(value = "SELECT * FROM Anotacoes a WHERE a.usuario_id = ?1", nativeQuery = true)
    List<Anotacao> buscarTodos(Long id);
}
