package br.com.letscode.spring.projetofinal.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor extends Usuario{
    public Professor(Long id, String nome, String email, String senha) {
        super(id, nome, email, senha);
    }
}
