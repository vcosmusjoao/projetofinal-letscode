package br.com.letscode.spring.projetofinal.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Aluno extends Usuario {
    public Aluno(Long id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }
}
