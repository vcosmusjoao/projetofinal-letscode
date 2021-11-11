package br.com.letscode.spring.projetofinal.repository;

import br.com.letscode.spring.projetofinal.model.Anotacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnotacaoRepository extends JpaRepository<Anotacao, Long> {
}
