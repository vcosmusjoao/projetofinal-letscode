package br.com.letscode.spring.projetofinal.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginForm {
    private String email;
    private String senha;
}
