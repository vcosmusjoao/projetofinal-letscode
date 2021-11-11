package br.com.letscode.spring.projetofinal.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UsuariosLogados {
    private Usuario usuarios = new Usuario();

    public void setUsuarios(Usuario usuarios) {
        this.usuarios=usuarios;
    }

    public Usuario getUsuarios() {
        return this.usuarios;
    }
}
