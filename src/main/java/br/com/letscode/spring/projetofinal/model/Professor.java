package br.com.letscode.spring.projetofinal.model;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class Professor extends Usuario{
    private String matriculaProfessor;

    public Professor(Long id, String nome, String email, String senha, String matriculaProfessor) {
        super(id, nome, email, senha);
        this.matriculaProfessor = matriculaProfessor;
    }

}
